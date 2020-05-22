public static void main(String[] args) {
        int N = 101;
        List<Integer> result = new ArrayList<>();

        for (long i = 1; i <= N; i++) {
            BigInteger integer = BigInteger.valueOf(i);
            if (integer.isProbablePrime(1)) {
                result.add((int) i);
            }
        }
        result.forEach(System.out::println);

    }