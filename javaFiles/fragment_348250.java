public class RandomGeneratorImproved extends RandomGenerator {

    private RandomGenerator rgen;

    public RandomGeneratorImproved() {

        rgen = RandomGenerator.getInstance();
    }

    public int generatePrime(int prime) {

        return generatePrime(0, prime - 1);
    }

    public int generatePrime(int lowp, int upperp) {

        int prime = rgen.nextInt(lowp, upperp);
        while (!isPrime(prime))
            prime = rgen.nextInt(lowp, upperp);
        return prime;
    }

    public boolean isPrime(int prime) {

        int n = 0; // <------ this is not used
        if (prime <= 1) {
            return false;
        }
        else if (prime <= 3) {
            return true;
        }
        else if (prime % 2 == 0 || prime % 3 == 0) {
            return false;
        }
        for (int i = 5; i < (prime / i); i += 6) {
            if (prime % i == 0) {
                return false;// "random number"+prime+"is not a prime number";
            }
        }
        return true;// "random number"+prime+"is a prime number";
    }
}