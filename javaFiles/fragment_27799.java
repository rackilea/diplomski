public class MergeSort {

  public static void main(String[] args) {
    int[] left = {1, 3, 5};
    int[] right = {2, 4, 6};
    int[] merged = {0, 0, 0, 0, 0, 0};
    merge(left, right, merged);
  }

  public static int[] merge(int[] left, int[] right, int[] bob) {
    System.out.print("Before merge: ");
    System.out.println(Arrays.toString(bob));
    int l = left.length;
    int r = right.length;

    int i = 0, j = 0, k = 0;

    while (i < l && j < r) {
      if (left[i] <= right[j]) {
        bob[k] = left[i];
        System.out.print("Merge step 1: ");
        System.out.println(Arrays.toString(bob));
        i++;

      } else {
        bob[k] = right[j];
        System.out.print("Merge step 2: ");
        System.out.println(Arrays.toString(bob));
        j++;

      }
      k++;
    }

    while (i < l) {
      bob[k] = left[i];
      System.out.print("Merge step 3: ");
      System.out.println(Arrays.toString(bob));
      i++;
      k++;
    }
    while (j < r) {
      bob[k] = bob[j];
      System.out.print("Merge step 4: ");
      System.out.println(Arrays.toString(bob));
      j++;
      k++;
    }

    return bob;
  }
}