private static ArrayList<Integer> primeFactors(int number) {
        return primeFactors(new ArrayList<Integer>(), number);
    }

    private static ArrayList<Integer> primeFactors(ArrayList<Integer> primeFactors, int number) {
        if (number == 1) {
            return primeFactors;
        }

        int newPrime=primeDividor(number);
        primeFactors.add(newPrime);
        return primeFactors(primeFactors, number/newPrime);
    }

    private static int primeDividor(int input) {
        return primes.stream()
                     .filter(e -> input % e == 0)
                     .findFirst()
                     .orElse(input);
    }