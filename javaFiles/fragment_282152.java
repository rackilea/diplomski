public class WebSocketRouter extends UntypedActor {
    private final Set<ActorRef> senders = new HashSet<>();

    private void addSender(ActorRef actorRef){
        senders.add(actorRef);
    }

    private void removeSender(ActorRef actorRef){
        senders.remove(actorRef);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof JoinMessage) {
            addSender(sender);
            getContext().watch(sender); // Watch sender so we can detect when they die.
        } else if (message instanceof Terminated) {
            // One of our watched senders has died.
            removeSender(sender);
        } else if (message instanceof String) {
            for (ActorRef sender : senders) {
                sender.tell(message, getSelf());
            }
        }
    }
}