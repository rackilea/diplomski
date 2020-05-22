class Hello {
  class World {
    public void doSomething() {
      Hello.this.doAnotherThing();
      // Here, "this" alone would refer to the instance of
      // the World class, so one needs to specify that the
      // instance of the Hello class is what is being
      // referred to.
    }
  }

  public void doAnotherThing() {
  }
}