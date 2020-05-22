public class Test {
    public static void main(String... args) {
        {
            Value x = new Value();
            // use the variable x
            System.out.println(x.i);
            // System.out.println(x.j); // does not compile
        }
        // use the type x
        System.out.println(x.i);
    }
}

class x {
    static int i = 42;
    static int j = 1;
}
class Value {
    int i = 100;
}