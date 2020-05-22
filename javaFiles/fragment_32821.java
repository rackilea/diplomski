public class PyramidPrinter {

  public static void main(String[] args) {
    int k = Integer.parseInt(args[0]);
    for (int n = 0; n < k; n++) {
      printRowVisiblePart(n);
    }
  }

  private static void printRowVisiblePart(int n) {
    System.out.print("*");
    for (int i = 0; i < n; i++) {
      System.out.print("o*");
    }
    System.out.println();  
  }
}