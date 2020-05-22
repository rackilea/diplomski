public static List<Integer> FACTORISATION(int n) {
    if (PRIME(n)) {
        // return a one-element array
        return Collections.singletonList(n);
    } else {
        // find a prime divisor, p
        for (int i = 2; i < Math.sqrt(n); i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(i);
            newList.addAll(FACTORISATION(n/i));
            return newList;
        }
        return Collections.emptyList();
    }
}