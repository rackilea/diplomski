import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.ServiceLocatorProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
import static org.junit.Assert.assertEquals;

public class JdkHttpGuiceTest {

    @Priority(1)
    public static class GuiceFeature implements Feature {
        @Override
        public boolean configure(FeatureContext context) {
            ServiceLocator locator = ServiceLocatorProvider.getServiceLocator(context);
            GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
            Injector injector = Guice.createInjector(new EncoderModule());
            GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
            guiceBridge.bridgeGuiceInjector(injector);
            return true;
        }
    }

    public static interface Encoder {
        String encode(String value);
    }

    public static class UppercaseEncoder implements Encoder {
        @Override
        public String encode(String value) {
            return value.toUpperCase();
        }
    }

    static class EncoderModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(Encoder.class).to(UppercaseEncoder.class);
        } 
    }

    @Path("test")
    public static class TestResource {
        @Inject
        private Encoder encoder;

        @GET
        public String get(@QueryParam("s") String s) {
            return encoder.encode(s);
        }
    }

    public static class AppConfig extends ResourceConfig {
        public AppConfig() {
            register(TestResource.class);
            register(GuiceFeature.class);
            register(new LoggingFilter(Logger.getAnonymousLogger(), true));
        }
    }

    private HttpServer server;

    @Before
    public void setUp() {
        server = JdkHttpServerFactory.createHttpServer(
                URI.create("http://localhost:8080/"), new AppConfig());
    }

    @After
    public void tearDown() {
        server.stop(1);
        server = null;
    }

    @Test
    public void injectionShouldWork() {
        final Response response = ClientBuilder.newClient().target("http://localhost:8080/test")
                .queryParam("s", "hello")
                .request().get();
        assertEquals(200, response.getStatus());
        assertEquals("HELLO", response.readEntity(String.class));
    }
}