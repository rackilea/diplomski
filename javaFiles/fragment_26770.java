public class SecureSquare {

    private static final double SECURE_SQUARE_LIMIT = Math.sqrt(Integer.MAX_VALUE);

    public static int square(int number) {
        if (Math.abs(number) > SECURE_SQUARE_LIMIT) {
            throw new ArithmeticException("Square overflow exception!");
        }
        return number * number;
    }

    public static void main(String[] args) {
        int number = square(-46340);
        System.out.println(number);
    }
}