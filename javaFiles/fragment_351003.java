public class Application {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        TestVerticle verticle = new TestVerticle();

        vertx.deployVerticle(verticle, res -> {
            if (res.failed())
                res.cause().printStackTrace();
        });
    }
}