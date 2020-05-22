import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
  public static void main(String args[]) {
    System.out.println("Odd length");
    test(new String[] { "aaa", "bbb", "ccc", "ddd", "eee" });
    System.out.println("Even length");
    test(new String[] { "xxx", "yyy" });
    System.out.println("Empty");
    test(new String[] {});
  }

  private static void test(String[] data) {
    List<String> temporary = new ArrayList<String>();
    temporary.addAll(Arrays.asList(data));
    for (int i = 0; i < temporary.size(); i = i + 2) {
      System.out.println("i= " + i + " first " + temporary.get(i).toString());
      int j = i + 1;
      if (j < temporary.size()) {
        System.out
            .println("i= " + j + " second " + temporary.get(j).toString());
      }
    }
  }
}