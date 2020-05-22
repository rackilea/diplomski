public static void main(String[] args) {
    int i = 0;
    int num = 0;

    List<Integer> primes = new ArrayList<Integer>();

    for (i = 1; i <= 100; i++) {
        int counter = 0;

        for (num = i; num >= 1; num--) {
            if (i % num == 0) {
                counter = counter + 1;
            }
        }

        if (counter == 2) {
            primes.add(i);
        }
    }
    System.out.println("The first 100 prime numbers are:");
    for(int prime : primes) {
        System.out.println(prime);
    }
}