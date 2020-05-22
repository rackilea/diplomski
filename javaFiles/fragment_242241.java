public static List<Integer> FACTORISATION(int n) {
    if (PRIME(n)) {
        // return a one-element array
        return ImmutableList.of(n);
    } else {
        // find a prime divisor, p
        for (int i = 2; i < Math.sqrt(n); i++) {
            return new ImmutableList.Builder<Integer>()
                .add(i)
                .addAll(FACTORISATION(n/i))
                .build();
        }
        return Collections.emptyList();
    }
}