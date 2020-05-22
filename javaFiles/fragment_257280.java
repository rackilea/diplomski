public class Test {
    public static void main(String[] args) {
        new Subclass(10).foo();
    }

    static class Superclass {
        private int x;

        Superclass(int x) {
            this.x = x;
        }
    }

    static class Subclass extends Superclass {
        Subclass(int x) {
            super(x);
        }

        public void foo() {
            Superclass y = this;
            System.out.println(y.x);
        }
    }
}