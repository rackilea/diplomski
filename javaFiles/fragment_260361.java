public class Test {

  enum Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE;
  }

  static class Baz {
    ImmutableSet<Color> colors;

    Baz(Set<Color> colors) {
      this.colors = Sets.immutableEnumSet(colors); // preserves enum constants 
                                                   // order, not insertion order!
    }
  }

  public static void main(String[] args) {
    ImmutableSet<Color> colorsInInsertionOrder = ImmutableSet.of(
        Color.GREEN, Color.YELLOW, Color.RED);
    System.out.println(colorsInInsertionOrder); // [GREEN, YELLOW, RED]
    Baz baz = new Baz(colorsInInsertionOrder);
    System.out.println(baz.colors); // [RED, YELLOW, GREEN]
  }
}