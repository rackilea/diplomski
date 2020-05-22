interface C {}
class A implements C {}

public class Test {

    private static void foo(Class<? extends C> clazz) {
    }

    public static void main(String[] args) {        
        foo(A.class);
    }
}