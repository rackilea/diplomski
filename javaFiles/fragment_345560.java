/**
 * Static only for the sake of example
 */
static class SpokeVerticle extends AbstractVerticle {

    private String id;

    @Override
    public void start() {
        this.id = UUID.randomUUID().toString();

        vertx.eventBus().consumer("processMessage", (request) -> {
            // Do something smart

            // Reply
            request.reply("I'm Spoke " + id + " and my reply is 42");
        });
    }
}