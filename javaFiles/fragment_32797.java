import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import static junit.framework.Assert.assertEquals;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ExtendedUriInfo;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class ResourceModelTest extends JerseyTest {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface ResourceAnnotation {

        String value();
    }

    @Path("root")
    @ResourceAnnotation("SomeValue")
    public static class ParentResource {

        @Path("sub")
        public ChildResource getChild() {
            return new ChildResource();
        }

        @GET
        public String get() {
            return "ROOT";
        }
    }

    public static class ChildResource {

        @GET
        public String get() {
            return "CHILD";
        }
    }

    @Provider
    public static class ResourceFilter implements ContainerResponseFilter {

        @Override
        public void filter(ContainerRequestContext requestContext,
                ContainerResponseContext responseContext) throws IOException {

            ExtendedUriInfo info = (ExtendedUriInfo) requestContext.getUriInfo();
            List<ResourceMethod> resourceLocators = info.getMatchedResourceLocators();
            if (!resourceLocators.isEmpty()) {
                Resource parent = resourceLocators.get(0).getParent();
                Class<?> parentClass = parent.getHandlerClasses().iterator().next();
                ResourceAnnotation anno = parentClass.getAnnotation(ResourceAnnotation.class);
                if (anno != null) {
                    responseContext.getHeaders().putSingle("X-SubResource-Header", anno.value());
                }
            }
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(ParentResource.class)
                .register(ResourceFilter.class);
    }

    @Override
    public void configureClient(ClientConfig config) {
        config.register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Test
    public void get_child_resource() {
        Response response = target("root/sub").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("SomeValue", response.getHeaderString("X-SubResource-Header"));
    }
}