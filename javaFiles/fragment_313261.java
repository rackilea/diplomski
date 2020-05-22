import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    ArrayList<Integer[]> myList = new ArrayList<Integer[]>();
    myList.add(new Integer[] { 5, 5 });
    myList.add(new Integer[] { 1, 1 });
    System.out.println(deepContains(myList, new Integer[] { 5, 5 }));
    System.out.println(deepContains(myList, new Integer[] { 5, 3 }));
  }

  public static boolean deepContains(List<Integer[]> list, Integer[] probe) {
    for (Integer[] element : list) {
      if (Arrays.deepEquals(element, probe)) {
        return true;
      }
    }
    return false;
  }
}