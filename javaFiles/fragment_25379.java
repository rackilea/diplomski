public enum Foo {

    ONE(new OneDelegate()), 
    TWO(new TwoDelegate()),
    THREE(new ThreeDelegate());

    // ////////////////////
    // Private stuff

    private final FooDelegate delegate;

    private Foo(FooDelegate delegate) {
        this.delegate = delegate;
    }

    // ////////////////////
    // Public methods

    public String doStuff(String stuff) {
        return delegate.doStuff(stuff);
    }

    // ////////////////////
    // Helper classes

    private static interface FooDelegate {
        String doStuff(String stuff);
    }

    private static class OneDelegate implements FooDelegate {
        @Override
        public String doStuff(String stuff) {
            return "One " + stuff;
        }
    }

    private static class TwoDelegate implements FooDelegate {
        @Override
        public String doStuff(String stuff) {
            return "Two " + stuff;
        }
    }

    private static class ThreeDelegate implements FooDelegate {
        @Override
        public String doStuff(String stuff) {
            return "Three " + stuff;
        }
    }
}