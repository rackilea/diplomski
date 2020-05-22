class Foo implements Trait1, Trait2 {
  public void ping() {
    Trait1$class.ping(this);    //works because `this` implements Trait1
  }

  public void pong() {
    Trait2$class.pong(this);    //works because `this` implements Trait2
  }
}