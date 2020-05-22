import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class AckingActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public static class Msg1 {}
    public static class Ack {}

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(Msg1.class, m -> getSender().tell(new Ack(), getSelf()))
            .matchAny(m -> log.info("unknown message"))
            .build();
    }
}