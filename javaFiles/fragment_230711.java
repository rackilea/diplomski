import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

public class ServletTest extends JerseyTest {

    @Path("/session")
    public static class SessionResource {

        @Inject
        HttpSession session;

        @GET
        public Response getSessionId() {
            return Response.ok(session.getId()).build();
        }
    }

    public static class HttpSessionFactory implements Factory<HttpSession> {

        private final HttpServletRequest request;

        @Inject
        public HttpSessionFactory(Provider<HttpServletRequest> requestProvider) {
            this.request = requestProvider.get();
        }

        @Override
        public HttpSession provide() {
            return request.getSession();
        }

        @Override
        public void dispose(HttpSession t) {
        }
    }

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    protected DeploymentContext configureDeployment() {
        ResourceConfig config = new ResourceConfig(SessionResource.class);
        config.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindFactory(HttpSessionFactory.class).to(HttpSession.class);
            }
        });
        return ServletDeploymentContext.forServlet(
                                 new ServletContainer(config)).build();
    }

    @Test
    public void test() {
        System.out.println(target("session").request().get(String.class));
    }
}