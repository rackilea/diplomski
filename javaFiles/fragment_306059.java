@Component
public class MyEventListener implements DisposableBean { 

    ... ctor with injected EventPublisher eventPublisher

    @EventListener
    public void onBranchCreatedEvent(BranchDeletedEvent event) {
        //do something
    }

    @EventListener
    public void onBranchCreatedEvent(BranchCreatedEvent event) {
        //do something
    }

    public void destroy() throws Exception {
         eventPublisher.unregister(this);
    }
}