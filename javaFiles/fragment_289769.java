public class Outer {

    public void print() {
        System.out.println("Hello");
    }

    private class Inner {

        public Inner() {
            print();
        }
    }
}