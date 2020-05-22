public static void main(final String[] args) throws Exception {
    final StringBuilder sb = new StringBuilder();
    final Random random = new Random();
    for (int i = 0; i < 1000; i++) {
        sb.append(random.nextInt(10));
    }
    final long t1 = System.currentTimeMillis();
    final String input = sb.toString();
    System.out.println(input);
    System.out.println(getMostFrequentSequence(input, -1));
    System.out.println(System.currentTimeMillis() - t1);
    final long t2 = System.currentTimeMillis();
    System.out.println(getMostFrequentSequence(input, 12));
    System.out.println(System.currentTimeMillis() - t2);
}