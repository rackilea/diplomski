class LooperVerticle extends AbstractVerticle {

    private int i = 4;

    @Override
    public void start() throws Exception {
        doWork();
    }

    private void doWork() {
        vertx.eventBus().send("channel", "", (o) -> {
            if (o.succeeded()) {
                System.out.println(o.result().body());
                i--;
                if (i > 0) {
                    doWork();
                }
            }
        });
    }
}

class WorkerVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("channel", (o) -> {
            // Generate some random number
            int num = ThreadLocalRandom.current().nextInt(0, 9);

            // Simulate slowness
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o.reply(num);
        });
    }
}