public class App extends UntypedActor {
  private int counter = 1000;

  @Override
  public void preStart() {
    // create the greeter actors
    List<ActorRef> actorRefs = new ArrayList();
    for (int i = 0; i < counter; i++) {
        final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class, i));
        this.getContext().watch(greeter);
        actorRefs.add(greeter);
    }
    // tell it to perform the greeting
    for (ActorRef actorRef : actorRefs) {
        actorRef.tell(Greeter.Msg.GREET, getSelf());
    }
  }

  @Override
  public void onReceive(Object msg) {

    if (msg instanceof DeadLetter) {
        System.out.println(msg);
    } else if (msg == Greeter.Msg.DONE) {
        if (--counter <= 0){
          getContext().stop(getSelf());
        }

    } else {
        unhandled(msg);
    }
  }

}