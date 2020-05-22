public class OuterClass {
    int outerVariable = 100;

    class InnerClass {
        int innerVariable = 20;

        int someMethod(int parameter) {
           //Do something.
        }       
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        InnerClass inner = outer.new InnerClass(); 
        System.out.println(inner.someMethod(3));
    }
}