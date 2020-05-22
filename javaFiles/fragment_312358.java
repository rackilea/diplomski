private static final Vertx vertx = Vertx.vertx();
private static final HttpClient client = vertx.createHttpClient(
        new HttpClientOptions()
                .setDefaultHost("localhost")
                .setDefaultPort(8443));
public static void main(final String[] args) {
    AtomicInteger hitCounter = new AtomicInteger(0);
    vertx.createHttpServer().requestHandler((c) -> {
        if (hitCounter.incrementAndGet() >= 5) {
            c.response().setStatusCode(200).end();
        }
        else {
            c.response().setStatusCode(202).end();
        }
    }).listen(8443);

    System.out.println("Server started");

    callServerUntilSuccess();
}

public static void callServerUntilSuccess() {
    client.request(HttpMethod.GET, "/", (r) -> {
        if (r.statusCode() == 200) {
            System.out.println("I'm done");
        }
        else {
            System.out.println("I'll try again");
            vertx.setTimer(1000, (l) -> callServerUntilSuccess());
        }
    }).end();
}