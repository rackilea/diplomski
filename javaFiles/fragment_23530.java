public class EventLoopExample {

static Map<String, AtomicInteger> threadCounts = new ConcurrentHashMap<>();

public static void main(String[] args) {
    printActive("Before starting VertX");

    Vertx vertx = Vertx.vertx();

    printActive("After starting VertX");
    for (int i = 0; i < 1000; i++) {
        vertx.deployVerticle(new MyVerticle());
        printActive("Regular verticle deployed");
    }

    printActive("Before deploying worker verticles");
    for (int i = 0; i < 1000; i++) {
        vertx.deployVerticle(new MyVerticle(), new DeploymentOptions().setWorker(true));
        printActive("Worker verticle deployed");
    }

    printActive("After everything deployed");

    System.out.println(new TreeMap(threadCounts));

    AtomicInteger count = new AtomicInteger(0);
    threadCounts.forEach((key, value) -> {
        count.addAndGet(value.get());
    });

    System.out.println(count.get());
}

private static void printActive(String message) {
    System.out.println(message);
    System.out.println(Thread.activeCount());
}

static class MyVerticle extends AbstractVerticle {

    @Override
    public void start() {
        threadCounts.putIfAbsent(Thread.currentThread().getName(), new AtomicInteger(0));
        threadCounts.get(Thread.currentThread().getName()).incrementAndGet();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopped");
    }
}
}