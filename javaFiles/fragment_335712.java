public class Apple extends Fruit {
  private final Colour c;

  public Apple(Colour c) {
      this.c = c;
  }

  public Apple() {
      this(Colour.RED);
  }
}