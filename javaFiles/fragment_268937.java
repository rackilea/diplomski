public class Test {

    static int x = 9;

    public static void main(String[] args) {
        boolean result = x++ >= showXAndReturn10();
        System.out.println(result); // False
    }

    private static int showXAndReturn10() {
        System.out.println(x); // 10
        return 10;
    }
}