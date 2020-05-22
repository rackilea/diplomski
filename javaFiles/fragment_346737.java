public class Base {
    public void A() {
        System.out.println("Hi");
    }
    public void A(int i, int j) {
        System.out.println("Bye");
    }
}

public class Sub extends Base {
    public void A() {
        System.out.println("Hey, La!");
    }
}

public class Test {
    public static void main(String[] args) {
        Sub a = new Sub();
        a.A();
        a.A(1, 1);//perfectly fine
    }
}