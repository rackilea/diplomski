import java.math.BigInteger;
import java.util.Scanner;
import java.util.LinkedList;


public class Test {

    Test(int number) {
        System.out.println("\n\nFibonacci series upto " + number + " numbers : ");
        LinkedList<BigInteger> list = new LinkedList<BigInteger>();
        for (int i = 1; i <= number; i++) {
            list.add(fibonacciLoop(i));
            if(list.size() == 10) {
                printFibo(list);
                list = new LinkedList<BigInteger>();
            }
        }
        if(!list.isEmpty()) printFibo(list);
    }

    public static void main(String args[]) {
        System.out.print("Enter number upto which Fibonacci series to print: ");
        new Test(new Scanner(System.in).nextInt());
    }

    private void printFibo(LinkedList<BigInteger> list) {
        for(BigInteger fiboNumber : list) {
             System.out.print(fiboNumber + " ");
        }
        System.out.println("");
    }

    public BigInteger fibonacciLoop(int number) {
        if (number == 1 || number == 2) {
            return BigInteger.valueOf(1);
        }
        BigInteger fibonacci = BigInteger.valueOf(1);
        BigInteger fibo1 = BigInteger.valueOf(1);
        BigInteger fibo2 = BigInteger.valueOf(1);
        for (int i = 3; i <= number; i++) {
            fibonacci = fibo1.add(fibo2);
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }
}