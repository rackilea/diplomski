public class MessageSender extends UntypedActor {

    public static Props props(ActorRef out) {
        return Props.create(MessageSender.class, out);
    }

    private final ActorRef out;
    private final ActorRef router;

    public MessageSender(ActorRef out) {
        this.out = out;
        this.router= getContext().actorSelection("/Path/To/WebSocketRouter");
    }

    @Override
    public void preStart() {
        router.tell(new JoinMessage(), getSelf());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            out.tell(message, getSelf());
        } else {
            unhandled(message);
        }
    }    
}