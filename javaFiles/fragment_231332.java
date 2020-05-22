import java.util.Scanner;

public class Primes {

 public static void main(String[] args) {

    StringJoiner joiner = new StringJoiner(",");

    Scanner sc = new Scanner(System.in);
    int start = sc.nextInt();
    int end = sc.nextInt();

    for (int i =start; i <= end; i++) {

        if (isPrime(i)) {
            joiner.add(Integer.toString(i));
        }

    }

    System.out.println(joiner.toString());
}