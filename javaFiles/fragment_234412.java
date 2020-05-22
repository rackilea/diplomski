package my.nsq

...

public class Module extends AbstractModule implements AkkaGuiceSupport {

    @Override
    protected void configure() {
        // Bind actors.
        bindActor(NSQRunner.class, NSQRunner.name);

        // Bind scheduler, it will run on the start of application.
        bind(Scheduler.class).asEagerSingleton();
    }
}