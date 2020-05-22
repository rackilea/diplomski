public class CrossdomainPolicyResourceSTest extends BaseTestClass {

static com.sun.jersey.api.client.Client client;

  @BeforeClass public static void 
startClient() {

        client = Client.create();
    }

  @Test public void 
getPolicy() {

        String response = 
            client
                .resource("http://localhost/crossdomain.xml")
                .get(String.class);

        assertTrue(response.startsWith("<?xml version=\"1.0\"?>"));
    }
}