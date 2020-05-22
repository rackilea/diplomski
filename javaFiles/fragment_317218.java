import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
  public static void main(String args[]) {
    String[] data = {"aaa","bbb","ccc","ddd"};
    List<String> temporary = new ArrayList<String>();
    temporary.addAll(Arrays.asList(data));
    for (int i = 0; i < temporary.size(); i = i + 2) {
      System.out.println("i= " + i + " first " + temporary.get(i).toString());
      int j = i + 1;
      System.out.println("i= " + j + " second " + temporary.get(j).toString());
    }
  }
}