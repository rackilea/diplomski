private static Map<Integer, Integer> factorize(int number) {
    Map<Integer, Integer> factors = new HashMap<Integer, Integer>();
    for (int i = 1; i < Math.sqrt(number); i++) {
        if (number % i == 0)
            factors.put(i, number / i);
    }
    return factors;
}