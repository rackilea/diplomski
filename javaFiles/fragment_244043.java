import java.util.Scanner;



public class Test {

public static boolean calcPrime(int num) {

    for(int i = 2; i < num; i++) {

        if(num % i == 0)
            return false;    // If number is divisible by any number, return false.
    }

    return true;     // If loop exits (means, number was not divisible by any number), return true.
}  



public static void printFactors(int num) {

    int nFactors = 0;

    for(int i = 2; i < num; i++) {

        if(num % i == 0) {

            System.out.println(num+" is divisible by "+i); 
            nFactors++;
        }
    }

    System.out.println(num+" has "+nFactors+" factors");
}  


public static void main(String[] args) {

    Scanner inputReader = new Scanner(System.in);

    int num = 0;
    boolean primeTest = false;

    while(true) {

        System.out.print("Enter an integer value: ");
        num = inputReader.nextInt();

        if(num == -1)
            break;

        primeTest = calcPrime(num);

        if(primeTest)
            System.out.println(num+" is prime.");
        else {

            System.out.println(num+" is not prime.");
            printFactors(num);
        }
    }
}
}