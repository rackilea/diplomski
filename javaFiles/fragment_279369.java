public class TestJSONResource extends JerseyTest {

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyTestContainerFactory();
    }

    @Path("test")
    public static class TestResource {
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response getJson() {
            Map<String, String> entity = Maps.newHashMap();
            entity.put("foo", "bar");

            Response response = Response.status(Response.Status.OK)
                    .entity(entity)
                    .type(MediaType.APPLICATION_JSON).build();
            return response;
        }
    }

    @Override
    protected DeploymentContext configureDeployment() {
        return DeploymentContext.builder(new ResourceConfig(TestResource.class))
                .contextPath("context1/context2")
                .build();
    }

    @Test
    public void testGet() {
        final WebTarget target = target("test");
        final String s = target.request().get(String.class);
        System.out.println(s);
    }
}