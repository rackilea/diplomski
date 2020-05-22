public class SMPBClientHandler implements HttpHandler {
    @Override
    public void handle(final HttpExchange exchange) throws IOException {
        OutputStream os = exchange.getResponseBody();
        os.write("response".getBytes());
        os.close();
    }
}