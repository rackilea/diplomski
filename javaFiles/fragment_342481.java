public class SchedulingTask {

    @Inject
    public SchedulingTask(final ActorSystem system,
                          @Named("update-db-actor") ActorRef updateDbActor) {
        system.scheduler().schedule(
            Duration.create(0, TimeUnit.MILLISECONDS), //Initial delay
            Duration.create(1, TimeUnit.DAYS),     //Frequency
            updateDbActor,
            "update",
            system.dispatcher(),
            null);
    }
}