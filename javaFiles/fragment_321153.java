import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.NameBinding;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Stack Overflow question http://stackoverflow.com/q/36878817/2587435
 * 
 * Run this like any other JUnit test. Only one required test dependency
 * 
 *  <dependency>
 *      <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *      <artifactId>jersey-test-framework-provider-inmemory</artifactId>
 *      <version>${jersey2.version}</version>
 *  </dependency>
 *
 * @author Paul Samsotha
 */
public class DynamicSubresourceTest extends JerseyTest {

    @NameBinding
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    public static @interface Status1000 {}

    @Provider
    @Status1000
    public static class Status1000Filter implements ContainerRequestFilter {
        @Override
        public void filter(ContainerRequestContext context) throws IOException {
            context.abortWith(Response.status(500).build());
        }
    }

    @Path("v1")
    public static class V1Resource {

        @GET
        public String get() {
            return "v1";
        }

        @Path("sub")
        public V1SubResource getSub() {
            return new V1SubResource();
        }

        public static class V1SubResource {
            @GET
            public String get() {
                return "v1subresource";
            }
        }
    }

    @Path("v2")
    @Status1000
    public static class V2Resource {

        @GET
        public String get() {
            return "v2";
        }

        @Path("sub")
        public V2SubResource getSub() {
            return new V2SubResource();
        }

        @Status1000
        public static class V2SubResource {
            @GET
            public String get() {
                return "v2subresource";
            }
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(V1Resource.class, V2Resource.class)
                .property(ServerProperties.WADL_FEATURE_DISABLE, true)
                .register(Status1000Filter.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Test
    public void should_return_1000_for_v2_resource_method() {
        final Response response = target("v2").request().get();
        assertThat(response.getStatus(), is(500));
    }

    @Test
    public void should_return_1000_for_v2_subresource_locator() {
        final Response response = target("v2/sub").request().get();
        assertThat(response.getStatus(), is(500));
    }

    @Test
    public void should_return_data_for_v1_resource_method() {
        final Response response = target("v1").request().get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is("v1"));
    }

    @Test
    public void should_return_data_for_v1_subresource_locator() {
        final Response response = target("v1/sub").request().get();
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is("v1subresource"));
    }
}