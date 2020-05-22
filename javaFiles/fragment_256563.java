private void multiply() {
    // this.innerCount = 0

    Inner inner = new Inner();
    // this.innerCount = 1

    this.new Inner();
    // this.innerCount = 2

    System.out.print(inner);  // Prints "2"

    // Creates a new Outer (with a separate innerCount)
    // then uses that to create a new Inner, which updates
    // the new innerCount
    inner = new Outer().new Inner();
    // inner.innerCount = 1

    System.out.println(inner);  // Prints "1"
}