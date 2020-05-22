import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.*;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * Example with default value for multipart field.
 *
 * Dependencies for JUnit test.
 *
 *   <dependency>
 *     <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *     <artifactId>jersey-test-framework-provider-grizzly2</artifactId>
 *     <scope>test</scope>
 *     <version>${jersey2.version}</version>
 *   </dependency>
 *   <dependency>
 *     <groupId>org.glassfish.jersey.media</groupId>
 *     <artifactId>jersey-media-multipart</artifactId>
 *     <version>${jersey2.version}</version>
 *  </dependency>
 */
public class MultiPartMissingTest extends JerseyTest {

    @Path("test")
    public static class TestResource {

        @POST
        @Produces(MediaType.TEXT_PLAIN)
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        public String post(@Context ContainerRequest request) {
            final String contentLength = request.getHeaderString(HttpHeaders.CONTENT_LENGTH);
            if (contentLength != null && Integer.parseInt(contentLength) != 0) {
                FormDataMultiPart multiPart = request.readEntity(FormDataMultiPart.class);
                FormDataBodyPart part = multiPart.getField("test");
                String result = part.getValueAs(String.class);
                return result;
            }
            return "no body";
        }
    }


    @Override
    public ResourceConfig configure() {
        return new ResourceConfig()
                .register(TestResource.class)
                .register(MultiPartFeature.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true))
                .register(new ExceptionMapper<Throwable>() {
                    @Override
                    public Response toResponse(Throwable t) {
                        t.printStackTrace();
                        return Response.serverError().entity(t.getMessage()).build();
                    }
                });
    }

    @Override
    public void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }

    @Test
    public void testWithBody() {
        final MultiPart multiPart = new FormDataMultiPart()
                .field("test", "testing");

        final Response response = target("test")
                .request()
                .post(Entity.entity(multiPart, multiPart.getMediaType()));

        assertEquals(200, response.getStatus());
        assertEquals("testing", response.readEntity(String.class));
    }

    @Test
    public void withoutBody() {
        final Response response = target("test")
                .request()
                .post(null);

        assertEquals(200, response.getStatus());
        assertEquals("no body", response.readEntity(String.class));
    }
}