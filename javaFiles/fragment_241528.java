public class PatchTest extends JerseyTest {

    @Path("patch")
    public static class PatchResource {
        @PATCH
        @Produces(MediaType.TEXT_PLAIN)
        public String getPatch(String request) {
            return "Patched " + request;
        }
    }

    @Override
    protected void configureClient(final ClientConfig config) {
        config.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
    }

    @Override
    public Application configure() {
        return new ResourceConfig(PatchResource.class);
    }

    @Test
    public void doPatchTest() {
        WebTarget target = target("patch");
        String response = target.request().method("PATCH", Entity.text("Hello"), String.class);
        Assert.assertEquals("Patched Hello", response);
        System.out.println(response);
    }
}