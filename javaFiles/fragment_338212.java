for (Future<Integer> future : futures) {
  try {
    Integer result = future.get();
  } catch(Exception ex) {
    // Handle exception.
  }
}