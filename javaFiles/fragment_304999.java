import java.util.List;
import java.util.ArrayList;

public class FiboAndPrime {


    static boolean IsPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    // Find all the prime numbers that are less than or equal to n
    static void allPrime(int n, List<Integer> prime_set ) {
        for(int i=2; i<=n; i++) {
            if(IsPrime(i)) System.out.print(i+ " ");
            prime_set.add(i);
        }
    }
    //Find the Fibonacci numbers that are less than or equal to n
    static void fibo(int n, List<Integer> fibo_set ) {
        int fibo[] = new int[n];
        fibo[0] = 0;
        fibo[1] = 1;
        System.out.print(fibo[0]+" "+fibo[1]+" ");
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            if (n >= fibo[i]) {
                System.out.print(fibo[i]+ " ");
                fibo_set.add(fibo[i]);
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int k = 40;


        System.out.println("The fibonacci list that smaller than " + k + " is:");
        List<Integer> fibo_set = new ArrayList<Integer>();
        fibo_set.add(0);
        fibo_set.add(1);
        List<Integer> prime_set = new ArrayList<Integer>();
        fibo(k,fibo_set);
        System.out.println();
        System.out.println("The prime list that smaller than " + k + " is:");
        allPrime(k,prime_set);

    fibo_set.retainAll(prime_set); // fibo_set now contains only elements in both sets

    System.out.println();
    System.out.println("intersection between the fibo and prime set:");
    for (Integer intersection : fibo_set) {
    System.out.println(intersection);
    }

    }
}