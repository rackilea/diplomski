@Singleton
public class Scheduler {

    @Inject
    public Scheduler(
            final ActorSystem system, 
            final Configuration configuration, 
            @Named(NSQRunner.name) ActorRef nsqRunner) {

        system.scheduler().scheduleOnce(
                Duration.create(1, TimeUnit.SECONDS),
                nsqRunner, 
                new NSQRunnerProtocol.StartConsumer(), 
                system.dispatcher(),
                null);        
    }
}