public class GridCoord
{
   public static void main(String[] args) {
      for( int i = 1; i <= 25; i++ ) {
         System.out.println( Arrays.toString( gridCoordinates( i ) ) );
      }
   }
   public static double[] gridCoordinates( int cell ) {
      int col = (cell-1) % 5;
      int row = (cell-1) / 5;
      double y1 = 9.0 - row * 0.6;
      double y2 = y1 - 0.6;
      double x1 = 3.0 + col * 0.6;
      double x2 = x1 + 0.6;
      return new double[] {x1, x2, y1, y2};
   }
}