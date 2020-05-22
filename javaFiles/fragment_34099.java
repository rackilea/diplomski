package jersey.stackoverflow.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse(ResponseObject ro) {
        final String json = "{\n"
                + "    \"response\": {\n"
                + "        \"description\": \"test charge\",\n"
                + "        \"email\": \"testing@example.com\",\n"
                + "        \"ip_address\": \"192.123.234.546\",\n"
                + "        \"person\": {\n"
                + "            \"name\": \"Matthew\",\n"
                + "            \"address_line1\": \"42 Test St\",\n"
                + "            \"address_line2\": \"\",\n"
                + "            \"address_city\": \"Sydney\",\n"
                + "            \"address_postcode\": \"2000\",\n"
                + "            \"address_state\": \"WA\",\n"
                + "            \"address_country\": \"Australia\",\n"
                + "            \"primary\": null\n"
                + "        }\n"
                + "    }\n"
                + "}";
        return Response.created(null).entity(json).build();
    }
}