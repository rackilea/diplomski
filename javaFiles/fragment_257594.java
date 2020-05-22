private ActorRef mediator = DistributedPubSub.get(getContext().system()).mediator();

@Override
public void onReceive(Object msg) throws Exception {
    String msgStr = msg.toString();
    String val = msgStr.substring(4);
    if (msgStr.startsWith("add")) {
        ActorRef act = context().actorOf(Props.create(User.class, val), val);
        // subscribe the newly created user on topic "allUsers"
        mediator.tell(new DistributedPubSubMediator.Subscribe("allUsers", act), self());
        System.out.println("user created: " + act);
    } else if (msgStr.startsWith("say")) {
        // broadcast text message to all subscribed users
        mediator.tell(new DistributedPubSubMediator.Publish("allUsers", new Text(val)), self());
    }
}