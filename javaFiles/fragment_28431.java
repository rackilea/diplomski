abstract class CustomAdder {
  abstract int add(int datum);

  static CustomAdder createCustomAdder(final int numberToAdd) {
    return new CustomAdder() {
      @Override int add(int datum) {
        return numberToAdd + datum;
      }
    };
  }
}

// elsewhere
CustomAdder fiveAdder = CustomAdder.createCustomAdder(5);
fiveAdder.add(4); // returns 9
CustomAdder tenAdder = CustomAdder.createCustomAdder(10);
tenAdder.add(20); // returns 30