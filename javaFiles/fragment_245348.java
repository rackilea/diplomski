public class CallStatic {
    public static void main(String... args) throws ClassNotFoundException {
        Class.forName("Static");
    }
}

class Static {
    static {
        System.out.println("static block run");
    }
}