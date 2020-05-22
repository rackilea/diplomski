import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.NameBinding;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Paul Samsotha
 */
public class DuplicateFormParamsTest extends JerseyTest {

    @Path("test")
    public static class TestResource {

        @POST
        @NoDuplicateParams
        @Consumes("application/x-www-form-urlencoded")
        public String post(@FormParam("param") String param) {
            return param;
        }
    }

    @NoDuplicateParams
    public static class DuplicateFormParamsFilter implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
            ContainerRequest cr = (ContainerRequest) requestContext;
            cr.bufferEntity();
            Form form = cr.readEntity(Form.class);
            MultivaluedMap<String, String> asMap = form.asMap();
            for (String key: asMap.keySet()) {
                if (asMap.get(key).size() > 1) {
                    throw new BadRequestException("Duplicate param: " + key);
                }
            }
        }
    }

    @NameBinding
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface NoDuplicateParams {
    }

    @Override
    public ResourceConfig configure() {
        enable(TestProperties.DUMP_ENTITY);
        enable(TestProperties.LOG_TRAFFIC);
        return new ResourceConfig(TestResource.class)
                .register(DuplicateFormParamsFilter.class);
    }

    @Test
    public void sdhoul_get_400_with_dup() {
        final Form form = new Form()
                .param("param", "value1")
                .param("param", "value2");
        final Response response = target("test").request().post(Entity.form(form));
        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void sdhoul_get_200_with_single() {
        final Form form = new Form()
                .param("param", "value1");
        final Response response = target("test").request().post(Entity.form(form));
        assertThat(response.getStatus(), is(200));
        assertThat(response.readEntity(String.class), is("value1"));
    }
}