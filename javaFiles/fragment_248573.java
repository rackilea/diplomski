static int countPrimeFactorsSet(int n) {
        Set<Integer> primeFactorSet = new HashSet<>();
        while (n % 2 == 0) {
            primeFactorSet.add(2);
            n /= 2;
        }
        double sn = Math.sqrt(n);  // compute Math.sqrt out of the loop
        for (int i = 3; i <= sn; i += 2) {
            while (n % i == 0) {
                primeFactorSet.add(i);
                n /= i;
            }
            sn = Math.sqrt(n);     // recompute after n changes
        }
        if (n > 2) {
            primeFactorSet.add(n);
        }
        return primeFactorSet.size();
    }

    static int countPrimeFactorsCounter(int n) {
        int count = 0; // using simple int
        if (n % 2 == 0) {
            count ++; // only add on first division
            n /= 2;
            while (n % 2 == 0) {
                n /= 2;
            }
        }
        double sn = Math.sqrt(n);  // compute Math.sqrt out of the loop
        for (int i = 3; i <= sn; i += 2) {
            if (n % i == 0) {
                count++; // only add on first division
                n /= i;
                while (n % i == 0) {
                    n /= i;
                }
                sn = Math.sqrt(n);     // recompute after n changes
            }
        }
        if (n > 2) {
            count++;
        }
        return count;
    }