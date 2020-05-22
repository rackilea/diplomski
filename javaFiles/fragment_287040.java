@Singleton
public final class Scheduler {
    @Inject
    private Event<SomethingChangedEvent> event;

    @Asynchronous
    private void scheduleSomething() {
        event.fire(new SomethingChangedEvent());
    }
}