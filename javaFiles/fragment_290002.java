public class Main {
    public static void main(String[] args) {        
        A a = new A();
        A.B b = a.new B();

        b.func(0); // Out is 1
    }
}