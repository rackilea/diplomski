@Path("/properties")
public class PropertiesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProperties() throws Exception {
        FileInputStream fis = new FileInputStream("test.properties");
        Properties props = new Properties();
        props.load(fis);
        return Response.ok(props).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postProperties(Properties properties) {
        StringBuilder builder = new StringBuilder();
        for (String key: properties.stringPropertyNames()) {
            builder.append(key).append("=")
                    .append(properties.getProperty(key)).append("\n");
        }
        return Response.created(null).entity(builder.toString()).build();
    }
}