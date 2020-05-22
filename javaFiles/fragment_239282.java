public static void main(String[] args) {
    System.out.println("sum: " + sum(10, 12));
    System.out.println("evens: " + evens(10, 20));
    System.out.println("odds: " + odds(10, 20));
    System.out.println("primes: " + primes(0, 100));
}

public static int sum(int from, int to) {
    int sum = 0;

    for (int i = from; i <= to; i++) {
        sum += i;
    }

    return sum;
}

public static List<Integer> evens(int from, int to) {
    List<Integer> evens = new ArrayList<>();

    if (from % 2 != 0) {
        from++;
    }

    for (int i = from; i <= to; i += 2) {
        evens.add(i);
    }

    return evens;
}

public static List<Integer> odds(int from, int to) {
    List<Integer> odds = new ArrayList<>();

    if (from % 2 == 0) {
        from++;
    }

    for (int i = from; i <= to; i += 2) {
        odds.add(i);
    }

    return odds;
}

public static List<Integer> primes(int from, int to) {
    List<Integer> primes = new ArrayList<>();
    boolean prime = false;

    for (int i = from; i <= to; i++) {
        if (isPrime(i)) {
            primes.add(i);
        }
    }

    return primes;
}

public static boolean isPrime(int n) {
    for(int i = 2; 2 * i < n; i++) {
        if(n % i == 0) {
            return false;
        }
    }
    return true;
}