private static final class BlockingHandler implements Handler<Future<String>> {

    private final YourBlockingService service;

    private final int counter;

    public BlockingHandler(int counter, YourBlockingService service) {
        this.counter = counter;
        this.service = service;
    }

    @Override
    public void handle(Future<String> event) {
        String result = service.blockingMethod("cycle " + this.counter + " executed", 2);
        event.complete(result);
    }
}