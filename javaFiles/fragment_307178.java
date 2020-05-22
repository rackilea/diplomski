@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest("server.port:19000")
public class DemoApplicationTests {

    private static final int CHUNK_SIZE = 1;
    private static final String HOST = "http://localhost:19000/echo";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void slowConnection() throws Exception {
        final HttpURLConnection connection = openChunkedConnection();
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

        writeAndWait(500, out, "chunk1");
        writeAndWait(1, out, "chunk2");

        out.close();

        expectedException.expect(IOException.class);
        expectedException.expectMessage("Server returned HTTP response code: 400 for URL: " + HOST);

        assertResponse("chunk1chunk2=", connection);
    }

    @Test
    public void fastConnection() throws Exception {
        final HttpURLConnection connection = openChunkedConnection();
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

        writeAndWait(1, out, "chunk1");
        writeAndWait(1, out, "chunk2");

        out.close();

        assertResponse("chunk1chunk2=", connection);
    }

    private void assertResponse(String expected, HttpURLConnection connection) throws IOException {
        Scanner scanner = new Scanner(connection.getInputStream()).useDelimiter("\\A");
        Assert.assertEquals(expected, scanner.next());
    }

    private void writeAndWait(int millis, OutputStreamWriter out, String body) throws IOException, InterruptedException {
        out.write(body);
        Thread.sleep(millis);
    }

    private HttpURLConnection openChunkedConnection() throws IOException {
        final URL url = new URL(HOST);
        final HttpURLConnection  connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(CHUNK_SIZE);
        return connection;
    }
}