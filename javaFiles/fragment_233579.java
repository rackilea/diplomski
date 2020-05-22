import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Singleton;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.ServiceLocatorProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.process.Inflector;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.ModelProcessor;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;
import org.glassfish.jersey.server.model.ResourceModel;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Stack Overflow https://stackoverflow.com/q/36410420/2587435
 * 
 * Run this like any other JUnit test. Only one required dependency
 * 
 *  <dependency>
 *      <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *      <artifactId>jersey-test-framework-provider-inmemory</artifactId>
 *      <version>${jersey2.version}</version>
 *      <scope>test</scope>
 *  </dependency>
 * 
 * @author Paul Samsotha
 */
public class PropsInjectionTest extends JerseyTest {

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Config {
        String value();
    }

    @Singleton
    public static class ConfigInjectionResolver implements InjectionResolver<Config> {

        @Override
        public Object resolve(Injectee injectee, ServiceHandle<?> root) {
            if (String.class == injectee.getRequiredType()) {
                Config anno = injectee.getParent().getAnnotation(Config.class);
                if (anno != null) {
                    String key = anno.value();
                    return key + "Value";
                }
            }
            return null;
        }

        @Override
        public boolean isConstructorParameterIndicator() { return false; }

        @Override
        public boolean isMethodParameterIndicator() { return false; }  
    }


    public static class Controller {
        @Config("Key")
        private String prop;

        public String getProp() {
            return prop;
        }
    }

    public static class ResourceFeature implements Feature {

        @Override
        public boolean configure(FeatureContext ctx) {
            final ServiceLocator locator = ServiceLocatorProvider.getServiceLocator(ctx);
            final Controller controller = new Controller();
            locator.inject(controller);

            final Resource.Builder builder = Resource.builder().path("test");
            final ResourceMethod.Builder methodBuilder = builder.addMethod("GET");
            methodBuilder.handledBy(new Inflector<ContainerRequestContext, String>(){
                @Override
                public String apply(ContainerRequestContext data) {
                    return controller.getProp();
                }
            });
            final Resource resource = builder.build();
            ctx.register(new MyModelProcessor(resource));
            return true;      
        }

        @Priority(100)
        static class MyModelProcessor implements ModelProcessor {
            private final Resource[] resources;

            public MyModelProcessor(Resource... resources) {
                this.resources = resources;
            }

            @Override
            public ResourceModel processResourceModel(ResourceModel rm, Configuration c) {
                final ResourceModel.Builder builder = new ResourceModel.Builder(false);
                // add any other resources not added in this feature. If there are none,
                // you can skip this loop
                for (Resource resource: rm.getResources()) {
                    builder.addResource(resource);
                }

                for (Resource resource: this.resources) {
                    builder.addResource(resource);
                }

                return builder.build();
            }

            @Override
            public ResourceModel processSubResource(ResourceModel rm, Configuration c) {
                return rm;
            }
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig()
                .register(new ResourceFeature())           
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true))
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(ConfigInjectionResolver.class)
                                .to(new TypeLiteral<InjectionResolver<Config>>(){})
                                .in(Singleton.class);
                    }
                });
    }

    @Test
    public void allShouldBeGood() {
        final Response response = target("test").request().get();
        assertThat(response.readEntity(String.class), is("KeyValue"));
    }
}