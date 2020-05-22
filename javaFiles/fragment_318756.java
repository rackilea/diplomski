private static final BitSet IS_PRIME = new BitSet(); static {
    IS_PRIME.set(2);
}

private static int IS_PRIME_LIMIT = 2;

public static boolean isPrime(int n) {
    int p = IS_PRIME_LIMIT;
    while (p < n) {
        p++;
        IS_PRIME.set(p);
        if (p % 2 == 0) {
            IS_PRIME.clear(p);
        } else {
            for (int i = 3; i * i <= p; i += 2)
                if (IS_PRIME.get(i) && p % i == 0) {
                    IS_PRIME.clear(p);
                    break;
                }
        }
    }
    IS_PRIME_LIMIT = p;
    return IS_PRIME.get(n);
}

public static List<Integer> findfactors(long n) {
    List<Integer> ret = new ArrayList<Integer>();
    int sqrtN = (int) Math.sqrt(n);

    for (int i = 2; n > 1 && i <= sqrtN; i++) {
        if (isPrime(i)) {
            while (n > 1 && n % i == 0) {
                n /= i;
                ret.add(i);
            }
        }
    }
    if (n > 1)
        ret.add((int) n);
    return ret;
}

public static void main(String... args) {
    // warm up
    for(int i=0;i<10000;i++)
        findfactors(600851475143L);

    //  time one lookup.
    long start = System.nanoTime();
    List<Integer> factors = findfactors(600851475143L);
    long time = System.nanoTime() - start;
    System.out.println(factors);
    System.out.printf("Took %.3f ms to find factors%n", time/1e6);
}