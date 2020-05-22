public class Test {
    public static void main(String[] args) {
        test(5);
    }

    private static void test(int i) {
        System.out.println("enter test with "+i);
        if(i>0) test(i-1);
        System.out.println("leave test with "+i);
    }
}