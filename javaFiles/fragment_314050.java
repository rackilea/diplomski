public class MyVerticle extends AbstractVerticle {

 private HttpServer server;

 public void start(Future<Void> startFuture) {
   server = vertx.createHttpServer().requestHandler(req -> {
     req.response()
       .putHeader("content-type", "text/plain")
       .end("Hello from Vert.x!");
     });

   // Now bind the server:
   server.listen(8080, res -> {
     if (res.succeeded()) {
       startFuture.complete();
     } else {
       startFuture.fail(res.cause());
     }
   });
 }
}