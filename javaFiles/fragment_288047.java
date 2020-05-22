import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyReader;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomReaderTest extends JerseyTest {

    private static final String DATA = "UselessStaticData";
    private static final String CUSTOM_MEDIA_TYPE = "application/useless";

    @Consumes(CUSTOM_MEDIA_TYPE)
    public static class UselessReader implements MessageBodyReader<String> {

        @Override
        public boolean isReadable(Class<?> aClass, Type type,
                                  Annotation[] annotations, MediaType mediaType) {
            return true;
        }

        @Override
        public String readFrom(Class<String> aClass, Type type, Annotation[] annotations,
                               MediaType mediaType, MultivaluedMap<String,String> multivaluedMap,
                               InputStream inputStream) throws IOException, WebApplicationException {
            return DATA;
        }
    }


    @Path("test")
    public static class TestResource {

        @GET
        @Produces(CUSTOM_MEDIA_TYPE)
        public InputStream post(String data) {
            return new ByteArrayInputStream("Test".getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig()
                .register(TestResource.class);
    }

    @Test
    public void testIt() {
        Response res = target("test")
                .register(UselessReader.class)
                .request(CUSTOM_MEDIA_TYPE)
                .get();

        assertThat(res.readEntity(String.class)).isEqualTo(DATA);
    }
}