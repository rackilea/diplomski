// I'm running in main(), so everything is static, just for the sake of example
private static Vertx vertx = Vertx.vertx();
public static void main(String[] args) throws InterruptedException {


    long start = System.currentTimeMillis();

    // In your case it should be operationA(), operationB(), etc
    // But I wanted to make the code shorter
    CompositeFuture.all(operationA(), operationA(), operationA()).setHandler((r) -> {
        if (r.succeeded()) {
            // You can even iterate all the results
            List<String> results = r.result().list();
            for (String result : results) {
                System.out.println(result);
            }
            // This will still print max(operationA, operationB, operationC)
            System.out.println("Took me " + (System.currentTimeMillis() - start) + " millis");
        }
        else {
            System.out.println("Something went wrong");
        }
    });
}


// Return a future, then fulfill it after some time
private static Future<String> operationA() {
    Future<String> future = Future.future();

    long millis = 1000 + ThreadLocalRandom.current().nextInt(500);
    vertx.setTimer(millis, (l) -> {
        future.complete("All is good " + millis);
    });

    return future;
}