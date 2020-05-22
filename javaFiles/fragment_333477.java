class Superclass {
    public static final void method() { }
}

class Subclass extends Superclass {
    public static void method() { } // doesn't compile
}