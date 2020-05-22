public static void main(String[] args) {
        int N = 101;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j < Math.sqrt(i - 1); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result.add(i);
            }
        }
        result.forEach(System.out::println);
}