public static void main(String[] args) {
  FlushingCache<String> studentsCache = new FlushingCache<>(Duration.ofSeconds(10), 3) {
    @Override
    protected void flush(List<String> batch) {
      println("### FLUSH TO DB " + batch);
    }
  };

  studentsCache.enqueue("1");
  studentsCache.enqueue("2");
  studentsCache.enqueue("3");

  studentsCache.enqueue("4");
}

private static void println(String message) {
  System.out.println(LocalTime.now().withNano(0).toString() + ": " + message);
}