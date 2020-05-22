public class Child extends AbstractActor {
  private final ActorRef target;

  public Child(ActorRef target) {
    this.target = target;
  }

  // ...
}