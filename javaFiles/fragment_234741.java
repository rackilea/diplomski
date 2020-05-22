import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
  public static void main(String args[]) {
    List<Integer> dataList = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      dataList.add(i);
    }
    Collections.shuffle(dataList);
    int[] num = new int[dataList.size()];
    for (int i = 0; i < dataList.size(); i++) {
      num[i] = dataList.get(i);
    }

    for (int i = 0; i < num.length; i++) {
      System.out.println(num[i]);
    }
  }
}