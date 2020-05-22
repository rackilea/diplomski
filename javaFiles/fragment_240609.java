public class Multiple {

    public static void main(String[] args) {

        long num1 = 10;
        long num2 = 20;

        if (isMultiple(num1, num2)) {
            System.out.println(num1 + " is a multiple of " + num2);
        } else {
            // num1 should come before num2 here
            System.out.println(num1 + " is not a multiple of " + num2);
        }
    }

    public static boolean isMultiple(long x, long y) {

        // check that x is a multiple of y
        return x % y == 0;
    }
}