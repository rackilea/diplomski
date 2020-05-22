public enum DogBehavior implements Behavior {
  BARK("Bark") {
    public void doBehavior() {
      // bark
    }
  },
  // etc.

  private final String name;

  DogBehavior(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}