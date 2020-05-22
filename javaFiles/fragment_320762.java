public class foo136 {
  private static int i = Integer.MAX_VALUE;
  public static void main(String[] args) {
    System.out.println("Starting the loop");
    for (int foo = 0; foo < 100; foo++)
      doit();
  }

  static void doit() {
    i = Integer.MAX_VALUE;
    long startTime = System.currentTimeMillis();
    while(!decrementAndCheck()){
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Finished the loop in " + (endTime - startTime) + "ms");
  }

  private static boolean decrementAndCheck() {
    return --i < 0;
  }
}