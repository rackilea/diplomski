private static Random random = new Random();

// true means '(', false means ')'
private static boolean[] buildRandomBalancedWord(int n) {
    boolean[] word = new boolean[n * 2];
    List<Integer> positions = IntStream.range(0, 2 * n).boxed()
        .collect(Collectors.toList());
    for (int i = n; i > 0; i--) {
        int index = random.nextInt(n + i);
        word[positions.remove(index)] = true;
    }
    return word;
}