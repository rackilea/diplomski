public class HealthCheckerTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(HealthChecker.class);
    }

    @Test
    public void testCreateGroup() {
        Response response = target("/health").request()
            .accept(MediaType.APPLICATION_JSON)
            .get();
        Assert.assertEquals("{\"status\":\"UP\"}", response.readEntity(String.class));
    }
}