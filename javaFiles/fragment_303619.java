class Foo {
    // The singleton instance
    static Foo theInstance = null;

    // Private constructor
    private Foo() {
    }

    // Public accessor for the one instance
    public static synchronized Foo getInstance() {
        if (theInstance == null) {
            theInstance = new Foo();
        }
        return theInstance;
    }

    // ...stuff for Foo to do, usually instance methods...
}