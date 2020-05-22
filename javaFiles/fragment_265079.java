public class Multiply {
    static int temp = 0;
    static int sum = 0;

    public static void main(String[] args) {
        int x = Integer.parseInt("11");
        int y = Integer.parseInt("9");
        int ans = multiply(x, y);
        System.out.println(ans);
    }

    public static int multiply(int x, int y) {
        if (x == 1) {
            System.out.println(x + " : " + y);
            return sum + y;
        }
        if (x % 2 == 0) {
            System.out.println(x + " : " + y);
        } else {
            System.out.println(x + " : " + y);
            sum = sum + y;
        }
        return multiply(x / 2, y * 2);
    }
}