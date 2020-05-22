import java.util.Arrays;

public class RemoveDupes {

  private static int removeDupes(final int[] array) {
    if(array.length < 2)
      return array.length;

    int outsize=1; // first is always kept

    outerloop: for (int consider = 1; consider < array.length; ++consider) {

      for(int compare=0;compare<outsize;++compare)
        if(array[consider]==array[compare])
          continue outerloop; // already present; advance to next compare

      // if we get here, we know it's new so append it to output
      array[outsize++]=array[consider]; // could test first, not worth it. 
    }

    return outsize; // length is last written position plus 1
  }

  private static void printRemoveDupes(int[] array) {
    int newlength=removeDupes(array);
    System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, newlength)));
  }

  public static void main(final String[] args) {
    printRemoveDupes(new int[] { 3, 45, 1, 2, 3, 3, 3, 3, 2, 1, 45, 2, 10 });
    printRemoveDupes(new int[] { 2, 2, 3, 3 });
    printRemoveDupes(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 });
  }
}