public class Worker extends AbstractActor {

  @Override
  public void preStart() {
      System.out.println("worker actor started");
  }

  @Override
  public void postStop() {
      System.out.println("worker actor stopped");
  }



  @Override
  public Receive createReceive() {
      return receiveBuilder()
              .matchAny(x -> getSender().tell(x, getSelf()))
              .build();
  }
}