public class Main {

    public static void main(String[] args) {
        Base<Child> b = new Base<>();
        // b.get() returns an instance of Base, not Child (however it's mistakenly cast to Child)
        Child1 c = b.get();
    }

    public static class Base<T extends Base>{
        public T get(){
            return (T) this;
        }
    }

    public static class Child extends Base {
    }
}