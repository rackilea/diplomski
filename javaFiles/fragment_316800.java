public static void main(String[] args) throws ParseException {
    List<String> items = Stream.generate(() -> "a").limit(47).collect(toList());
    final int blockSize = 5;
    List<List<String>> chunks = new ArrayList<>();
    for (int i = 0; i < items.size(); i += blockSize) {
        chunks.add(items.subList(i, Math.min(i + blockSize, items.size())));
    }
    chunks.forEach(System.out::println);
}