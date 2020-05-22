public class MyWorkItem implements Callable<Integer> {
  public Integer call() throws Exception {
    int result = new Random().nextInt(5);

    // Randomly fail.
    if (result == 0) {
      throw new IllegalArgumentException("Fail!");
    }

    return result;
  }
}