public class DeployerVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        System.out.println("Main verticle has started, let's deploy another...");

        // Deploy it as a worker verticle
        vertx.deployVerticle("io.example.WorkerVerticle", 
                             new DeploymentOptions().setWorker(true));
    }
}


// ----

package io.example;
/**
 * An example of a worker verticle
 */
public class WorkerVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        System.out.println("[Worker] Starting in " +
            Thread.currentThread().getName());

        // consume event bus messages sent to address "sample.data"
        // reply with incoming message transformed to upper case
        vertx.eventBus().<String>consumer("sample.data", message -> {

            Thread.sleep(1000); // will not block the event loop
                                // but only this verticle

            System.out.println("[Worker] Consuming data in " + 
                Thread.currentThread().getName());
            String body = message.body();
            message.reply(body.toUpperCase());
        });
    }
}