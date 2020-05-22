public class EventBusExample {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new LooperVerticle());
        vertx.deployVerticle(new WorkerVerticle());
    }
}