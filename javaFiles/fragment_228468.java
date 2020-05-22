import java.*;
import java.util.Scanner;

public class Main {

    public static int Primes(int n, int k) {
        //System.out.println("The values for n and k are: " + n + " and " + k);
        return ((k < 2 && n < 2) ? PrintPrimes(n) : (k == 1 && n > 1) ? PrintPrimes(n) : (n % k) != 0 ? Primes(n, k-1) : Primes(n-1, n-2));
    }

    public static int PrintPrimes(int n) {
        System.out.println(n);
        return ((n == 1) ? n : Primes(n-2, n-3));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        Primes(num, (num-1));
    }

}