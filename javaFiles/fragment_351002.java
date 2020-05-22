import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class TestVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        Router router = Router.router(vertx);

        router.route("/Test1").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.setChunked(true);
            response.write("Test1 \n");

            routingContext.vertx().setTimer(1000, tid ->  routingContext.next());
        });

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080, "127.0.0.1", res -> {
                    if (res.succeeded())
                        startFuture.complete();
                    else
                        startFuture.fail(res.cause());
                });
    }
}