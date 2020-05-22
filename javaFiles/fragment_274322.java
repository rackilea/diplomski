import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TestHttpServer {
    public static void main(String[] args) throws IOException {
        final HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8765), 0);

        server.createContext("/test", httpExchange -> {
            String response = "<html>TEST!!!</html>";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.createContext("/stop", httpExchange -> server.stop(1));

        server.start();
    }
}