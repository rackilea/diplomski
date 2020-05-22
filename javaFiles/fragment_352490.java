import org.junit.Before

public class TestClient {
    private static final int port = 20000 + new Random().nextInt(10000);
    private MyServer server;

    @Before
    public void setup() {
        // setup server
        server = new MyServer(port);
        server.start();
    }

    @Test
    public void testX() {
        // test x
    }

    @Test
    public void testY() {
        // test y
    }
}