public class SimpleTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Service.class);
    }

    @Test
    public void test() {
        String hello = target("service").request().get(String.class);
    }
}