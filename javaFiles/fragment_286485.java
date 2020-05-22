import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Parameter;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * See http://stackoverflow.com/q/39411704/2587435
 * 
 * Run like any other JUnit test. Only one require dependency
 * <dependency>
 *   <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *   <artifactId>jersey-test-framework-provider-grizzly2</artifactId>
 *   <version>${jersey2.version}</version>
 *   <scope>test</scope>
 * </dependency>
 *
 * @author Paul Samsotha
 */
public class InjectionTest extends JerseyTest {

    @Path("test")
    public static class TestResource {
        @GET
        public String get(@MagicAnnotation MagicWrapper magic) {
            return magic.get();
        }
    }

    @Provider
    public static class MagicFilter implements ContainerResponseFilter {

        @MagicAnnotation
        private MagicWrapper magic;

        @Override
        public void filter(ContainerRequestContext request, ContainerResponseContext response) {
            response.getHeaders().add("X-Magic-Header", magic.get());
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig()
            .register(TestResource.class)
            .register(MagicFilter.class)
            .register(new LoggingFilter(Logger.getAnonymousLogger(), true))
            .register(new AbstractBinder() {
                @Override
                public void configure() {
                    bindFactory(MagicWrapperFactory.class)
                            .to(MagicWrapper.class)
                            .proxy(true)
                            .proxyForSameScope(false)
                            .in(RequestScoped.class);
                    bind(MagicInjectionResolver.class)
                            .to(new TypeLiteral<InjectionResolver<MagicAnnotation>>(){})
                            .in(Singleton.class);
                    bind(MagicValueFactoryProvider.class)
                            .to(ValueFactoryProvider.class)
                            .in(Singleton.class);
                }
            });
    }

    @Override
    public TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    public DeploymentContext configureDeployment() {
        return ServletDeploymentContext.forServlet(new ServletContainer(configure())).build();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.PARAMETER, ElementType.FIELD})
    public static @interface MagicAnnotation {
    }

    public static class MagicWrapper {
        private String value;

        /* need to proxy */
        public MagicWrapper() {   
        }

        public MagicWrapper(String value) {
            this.value = value;
        }

        public String get() {
            return this.value;
        }
    }

    public static class MagicWrapperFactory implements Factory<MagicWrapper> {
        @Context
        private HttpServletRequest request;

        @Override
        public MagicWrapper provide() {
            return new MagicWrapper(request.getParameter("value"));
        }

        @Override
        public void dispose(MagicWrapper magic) {}
    }

    public static class MagicValueFactoryProvider implements ValueFactoryProvider {

        @Inject
        private ServiceLocator locator;

        @Override
        public Factory<?> getValueFactory(Parameter parameter) {
            if (parameter.isAnnotationPresent((MagicAnnotation.class))) {
                final MagicWrapperFactory factory = new MagicWrapperFactory();
                locator.inject(factory);
                return factory;
            }
            return null;
        }

        @Override
        public PriorityType getPriority() {
            return Priority.NORMAL;
        }
    }

    public static class MagicInjectionResolver implements InjectionResolver<MagicAnnotation> {

        @Inject @Named(InjectionResolver.SYSTEM_RESOLVER_NAME)
        private InjectionResolver<Inject> systemResolver;

        @Override
        public Object resolve(Injectee injectee, ServiceHandle<?> handle) {
            if (injectee.getRequiredType() == MagicWrapper.class) {
                return systemResolver.resolve(injectee, handle);
            }
            return null;
        }

        @Override
        public boolean isConstructorParameterIndicator() { return false; }

        @Override
        public boolean isMethodParameterIndicator() { return true; }
    }

    @Test
    public void testInjectionsOk() {
        final Response response = target("test").queryParam("value", "HelloWorld")
                .request().get();
        assertEquals("HelloWorld", response.readEntity(String.class));
        assertEquals("HelloWorld", response.getHeaderString("X-Magic-Header"));
    }
}