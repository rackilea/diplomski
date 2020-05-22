class Bar extends Foo {

    Bar() {
        // Explicit call to a constructor of the super class is omitted, so a
        // default one (to Foo()) is generated:
        // super();
    }

}