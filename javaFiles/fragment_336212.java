public class ConstructorCallsOverride {
    public static void main(String[] args) {
        abstract class Base {
            Base() { overrideMe(); }
            abstract void overrideMe(); 
        }
        class Child extends Base {
            final int x;
            Child(int x) { this.x = x; }
            @Override void overrideMe() {
                System.out.println(x);
            }
        }
        new Child(42); // prints "0"
    }
}