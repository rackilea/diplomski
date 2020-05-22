import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

class CustomExceptionHandler implements SubscriberExceptionHandler {
    @Override
    public void handleException(Throwable exception, SubscriberExceptionContext context) {
        System.out.println("Handler '"+context.getSubscriber()+"' could not handle '"+context.getEvent().getClass().getName()+"'["+context.getEvent()+"]: " + exception.getMessage());
    }
}