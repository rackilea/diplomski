class Base {
    public int a = 1;
    public int method() {
        return 1;
    }
}

class Sub extends Base {
    public int a = 2;
    public int method() {
        return 2;
    }
}

public class Main {
    public static void main(String[] args) {        
        Sub s = new Sub();
        Base b = s;
        System.out.println(s.a);        // 2
        System.out.println(b.a);        // 1
        System.out.println(s.method()); // 2
        System.out.println(b.method()); // 2
    }
}