class GeneratePrime{
 public static boolean isPrime(int x)
    {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

public static void main(String args[]){
    int currentNumber = 2;
    int primesFound = 0;

    while (primesFound < 100) {
        if (isPrime(currentNumber)) {
            primesFound++;

            System.out.print (currentNumber + " ");
            if (primesFound % 10 == 0) {
                System.out.println();
            }
        }

        currentNumber++;
    }
}}