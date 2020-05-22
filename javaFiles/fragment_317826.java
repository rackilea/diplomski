@Test
public void combinations() {
    int[] prefixes = new int[]{ 0, 1, 2, 3, 4 };
    int[] suffixes = new int[]{ 0, 1, 2, 3, 4, 5 };

    List<String> literals = new ArrayList<>();
    for (int prefix: prefixes) {
        for (int suffix: suffixes) {
            literals.add("" + prefix + suffix);
        }
    }

    Random random = new Random();
    while (!literals.isEmpty()) {
        String literal = literals.remove(random.nextInt(literals.size()));
        System.out.println(literal);
    }
}