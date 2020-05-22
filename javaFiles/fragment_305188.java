public class JavaStyleActor extends AbstractActor {

  @Override
  public Receive createReceive() {
    return receiveBuilder()
      .match(RequestMonies.class, req -> {
        // handle request monies...
      })
      .match(CheckStatus.class, check -> {
        // ...
      })
      .build();
  }

}