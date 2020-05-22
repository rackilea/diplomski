class Example {
    private int a;
    private int b;

    Example(int a) {
        // These work:
        this.a = a;
        this.b = 42;

        // This also works and does the same thing as `this.b = 42;`
        b = 42;

        // This fails to set the instance field `a`, because it assigns the value
        // of the `a` parameter to...the `a` parameter
        a = a; // Doesn't do what one probably wanted
    }
}