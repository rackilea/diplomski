public enum Foo {

    ONE, TWO, THREE;

    // ////////////////////
    // Public methods

    public String doStuff(String stuff) {
        switch(this) {
            case ONE:
                return doStuffOne(stuff);
            case TWO:
                return doStuffTwo(stuff);
            case THREE:
                return doStuffThree(stuff);

    // If we're handing all enum cases, we shouldn't need
    // a default (and per comments below, if we leave out
    // the default, we get the advantage that the compiler
    // will catch it if we add a new enum value but forget
    // to add the corresponding doStuff() handler

    //      default:
    //          throw new IllegalStateException("Who am I?");
        }
    }

    // ////////////////////
    // Static helpers

    private static String doStuffOne(String stuff) {
            return "One " + stuff;
    }

    private static String doStuffTwo(String stuff) {
            return "Two " + stuff;
    }

    private static String doStuffThree(String stuff) {
            return "Three " + stuff;
    }
}