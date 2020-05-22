/**
 * To test: 
 * 
 * ```` bash
 * $ curl -v -H "Content-Type: application/json" \
 *   -d '{"name":"Testing!"}' http://localhost:8000
 * ````
 */
public static void main(String[] args) throws IOException {
    // Creates a basic HTTP server, with default Executor and system default socket
    // backlog (second parameter in create method, 0)
    final HttpServer server = HttpServer.create(
        new InetSocketAddress("localhost", 8000), 0);
    // context MUST start with "/". Root context is just "/"
    // HttpHandler implemented as lambda, note that HttpHandler#handle() throws an
    // IOException, so no need to catch it
    server.createContext("/", (he) -> {
        try {
            System.out.println(he.getRequestURI());
            final InputStream in = he.getRequestBody();
            final OutputStream out = he.getResponseBody();

            // first send header, than response body, if any
            // use default buffer size suited for your use case
            final byte[] buffer = new byte[in.available() == 0 ? 1024 : in.available()];
            System.out.println("buffer size=" + buffer.length);     

            // preferrable, specify *exact* size of response body. If not known, use 0
            // < HTTP/1.1 200 OK
            // < Date: Thu, 21 Jul 2016 08:14:25 GMT
            // < Transfer-encoding: chunked
//            he.sendResponseHeaders(200, 0);
//            int length;
//            while ((length = in.read(buffer, 0, buffer.length)) >= 0) {
//                out.write(buffer, 0, length);
//            }

            // better way of doing it: buffer response body and set content length
            // < HTTP/1.1 200 OK
            // < Date: Thu, 21 Jul 2016 08:11:40 GMT
            // < Content-length: 19
            final ByteArrayOutputStream baos = new ByteArrayOutputStream(buffer.length);
            int length;
            while ((length = in.read(buffer, 0, buffer.length)) >= 0) {
                baos.write(buffer, 0, length);
            }
            he.sendResponseHeaders(200, baos.size());
            baos.writeTo(out); // no need to close() of flush() ByteArrayOutputStream

        } finally {
            // Essential: HttpExchange must be closed
            he.close();
        }
    });
    server.start();
}