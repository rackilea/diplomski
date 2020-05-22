package ro.redeul.test;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("x: " + Test.class.getMethod("method").getReturnType().toString());
    }

    public Test[][] method() {
        return null;
    }
}