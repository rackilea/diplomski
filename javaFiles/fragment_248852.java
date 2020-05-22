public class Foo2 {
   private static final int COLS = 10;
   private static final int ROWS = 10;

   public static void main(String[] args) {
      System.out.printf("%2s", "");
      for (int i = 0; i < COLS; i++) {
         System.out.printf("%8d", (i + 1));
      }
      System.out.println();
      for (int i = 0; i < ROWS; i++) {
         int row = i + 1;
         System.out.printf("%2d", row);
         for (int j = 0; j < ROWS; j++) {
            double myDouble = (double) row / (j + 1);
            System.out.printf("%8.2f", myDouble);
         }
         System.out.println();
      }
   }
}