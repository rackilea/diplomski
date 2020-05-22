public class PrimeCheckerv2 {
    public static void main(String[] args) throws IOException {
        BufferedReader Reader = new BufferedReader(new InputStreamReader(
                System.in));

        int factor = 2;
        System.out.println("Please input a number.");
        int number = Integer.parseInt(Reader.readLine());

        if (number == 1) {
            System.out.println(number + " is neither prime nor composite.");
        } else {
            while (factor <= Math.sqrt(number)) {
                factor++;
                if (isPrime(factor, number)) {
                    System.out.println(number + " is a prime number.");
                } else {
                    System.out.println(number
                            + " is a composite number (not prime).");
                }

            }
        }

    }

    public static boolean isPrime(int number, int factor) {
        return number % factor != 0;
    }

}