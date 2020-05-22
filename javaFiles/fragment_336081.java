import java.math.*;
import java.util.ArrayList;
public class Fibonacci {

    public static void main(String[] args) {
        for (int n=1; n<50; n++) {
        System.out.println("Element "+ n + " of the sequence: " + newFib(n));
        }

    }

    public static ArrayList<BigInteger> memo = new ArrayList<BigInteger>();
        static BigInteger newFib(int n){
            assert n >= 1: "the fibonacci sequence starts at 1"; 
            BigInteger result=BigInteger.valueOf(1);

            if (memo.size() - 1 >= n && memo.get(n) != null) {
                return memo.get(n);
            }
            else if( n  == 1  || n  ==  2 ) {
                memo.add(n-1, BigInteger.valueOf(1));
                return BigInteger.valueOf(1);
            }
            else {
                result= newFib(n-1).add(newFib(n-2));
                memo.add(n,result);
                return result;
            }
        }
}