import java.util.BitSet;

public class Main {
   public static void main(String[] args) {
      // Create a BitSet object, which can store 128 Options.
      BitSet bs = new BitSet(128);
      bs.set(0);// equal to bs.set(0,true), set bit0 to 1.
      bs.set(64,true); // Set bit64

      // Returns the long array used in BitSet
      long[] longs = bs.toLongArray();

      System.out.println(longs.length);  // 2
      System.out.println(longs[0]); // 1
      System.out.println(longs[1]); // 1
      System.out.println(longs[0] ==longs[1]);  // true
   }
}