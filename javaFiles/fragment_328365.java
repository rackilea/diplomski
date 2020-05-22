public class Test {

    public static void main(String[] args) {
        int x = getNumber();
        printNumber(x);
    }

    public static int getNumber() {
        int x = 5;
        return x;
    }

    public static void printNumber(int x) {
        System.out.println(x);
    }
}