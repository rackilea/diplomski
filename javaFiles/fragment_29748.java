**
 * Simple actor that takes another actor and forwards all messages to it.
 * Useful in unit testing for capturing and testing if a message was received.
 * Simply pass in an Akka JavaTestKit probe into the constructor, and all messages
 * that are sent to this actor are forwarded to the JavaTestKit probe
 * Ref: https://gist.github.com/jconwell/8153535
 */
public class ForwardingActor extends UntypedActor {
    final ActorRef target;
    public ForwardingActor(ActorRef target) {
        this.target = target;
    }
    @Override
    public void onReceive(Object msg) {
        target.forward(msg, getContext());
    }
}