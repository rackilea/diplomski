public class Primes {

 public static void main(String[] args) {

    String separator = "";

    Scanner sc = new Scanner(System.in);
    int start = sc.nextInt();
    int end = sc.nextInt();

    for (int i =start; i <= end; i++) {

        if (isPrime(i)) {
            System.out.printf(separator + "%d", i);

            separator = ",";
        }

    }
}