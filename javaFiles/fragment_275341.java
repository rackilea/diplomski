import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class TestConfiguration extends JerseyTest {

    @Path("/configuration")
    public static class ConfigurationResource {

        @Context
        Configuration config;

        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public Response getConfig() {
            StringBuilder builder = new StringBuilder("============\n");
            Map<String, Object> props = config.getProperties();

            for (Map.Entry<String, Object> entry : props.entrySet()) {
                builder.append(entry.getKey()).append(" : ")
                        .append(entry.getValue()).append("\n");
            }
            builder.append("=============");
            return Response.ok(builder.toString()).build();
        }
    }

    @Override
    public Application configure() {
        Map<String, Object> mapProp = new HashMap<String, Object>();
        mapProp.put("message", "HelloWorld");
        return new ResourceConfig(ConfigurationResource.class)
                .setProperties(mapProp);
    }

    @Test
    public void testGetConfiguration() {
        String response = ClientBuilder.newClient()
                .target("http://localhost:9998/configuration")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        System.out.println(response);
    }
}