public class MySet {
   private final int MAXALLOWEDSETVALUE = 2000;
   private boolean[] data;

   public MySet(int... elts) {
      data = new boolean[MAXALLOWEDSETVALUE + 1];

      for (int eltNdx = 0; eltNdx < elts.length; eltNdx++) {
         if (elts[eltNdx] <= MAXALLOWEDSETVALUE) { //Prevent ArrayIndexOutOfBoundsException
            data[elts[eltNdx] + 1] = true;
         } else {
            //Above the maximum size. Either don't store or handle accordingly.
         }
      }
   }

   public MySet(MySet anotherSet) {
      System.arraycopy(anotherSet.data, 0, this.data, 0, MAXALLOWEDSETVALUE);
   }
}