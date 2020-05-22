import akka.actor.AbstractActor;

public class AckingProducer extends AckingActor {
    private AbstractActor.Receive producerBehavior;

    public AckingProducer() {
        producerBehavior =
            receiveBuilder()
                .matchEquals("foo", m -> getSender().tell("bar", getSelf()))
                .matchEquals("ping", m -> getSender().tell("pong", getSelf()))
                .build();
    }

    @Override
    public Receive createReceive() {
        return producerBehavior.orElse(super.createReceive());
                            // ^ chain the Receive blocks with orElse
                            // e.g., behavior1.orElse(behavior2).orElse(behavior3)
    }
}