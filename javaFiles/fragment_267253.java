public class FinalTest {
    public static void main(String[] args) {
        String s = null;
        name(s);
        Object o = null;
        name(o);
        Integer i = null;
        name(i);
    }

    public static void name(String s) {
        System.out.println("String");
    }

    public static void name(Object s) {
        System.out.println("Object");
    }

    public static void name(Integer s) {
        System.out.println("Integer");
    }
}