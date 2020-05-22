public class RangeFactorial {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int max = scan.nextInt();
        int min = scan.nextInt();

        if (max < 0 || min < 0) {
            System.out.println("Invalid Params");
        }

        for (int i = min; i <= max; i++) {
            System.out.println("Factorial for " + i + " is: " + factorial(i));
        }

        scan.close();
    }

    private static int factorial(int i) {
        if (i <= 1) {
            return 1;
        }

        return i * factorial(i-1);
    }
}