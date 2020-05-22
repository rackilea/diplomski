public class Main {
    private class Test {
        protected int hello;
    }
    private class TestNext extends Test {
        private TestNext() {
            this.hello = 1;
        }
    }
}