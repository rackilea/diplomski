public class MergeSort {
  public static void sort(List<Integer> list) {
    if (list.size() < 2) {
      return;
    }
    int mid = list.size()/2;
    List<Integer> left = new ArrayList<Integer>(list.subList(0, mid));
    List<Integer> right = new ArrayList<Integer>(mid, list.size()));

    sort(left);
    sort(right);
    merge(left, right, list);
  }

  private static void merge(
      List<Integer> left, List<Integer> right, List<Integer> list) {
    int leftIndex = 0;
    int rightIndex = 0;
    int listIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      if (left.get(leftIndex) < right.get(rightIndex)) {
        list.set(listIndex++, left.get(leftIndex++));
      } else {
        list.set(listIndex++, right.get(rightIndex++));
      }
    }
    while (leftIndex < left.size()) {
      list.set(listIndex++, left.get(leftIndex++));
    }
    while (rightIndex < right.size()) {
      list.set(listIndex++, right.get(rightIndex++));
    }
  }
}