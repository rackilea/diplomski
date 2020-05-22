List<Integer> primes = findPrimes(N);
    Set<Integer> set = new LinkedHashSet<>();

    for (int i = 0; i < primes.size(); i++) {

        int prime = primes.get(i);

        if (!set.contains(prime)) {
            int mirror = hasMirror(prime, primes);

            if (mirror == 0) {
                continue;
            }

            set.add(prime);
            set.add(mirror);
        }
    }