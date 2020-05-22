public class foo {
    static public void main(String[] params) {
        Object v1 = 1;
        Object v2 = "Test";
        Object v3 = 7.31;

        System.out.println(v1 + " " + v1.getClass().getName());
        System.out.println(v2 + " " + v2.getClass().getName());
        System.out.println(v3 + " " + v3.getClass().getName());
    }
}