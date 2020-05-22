import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class serverTest {

    public static void main(String[] args) throws Exception {
HttpServer server = Vertx.vertx().createHttpServer();
        server.websocketHandler(new Handler<ServerWebSocket>() {
            @Override
            public void handle(ServerWebSocket webs) {
                System.out.println("Client connected");
                webs.writeBinaryMessage(Buffer.buffer("Hello user"));
                System.out.println("Client's message: ");
                webs.handler(data -> {System.out.println("Received data " + data.toString("ISO-8859-1"));});

            }
        });

        server.listen(8080, "localhost", res -> {
            if (res.succeeded()) {
                System.out.println("Server is now listening!");
            } else {
                System.out.println("Failed to bind!");
            }
        });
    }
}