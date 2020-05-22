import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void tryIt(List... lists) {
    System.out.println("You insert " + lists.length + " lists.");
  }
    public static void main(String[] args) {
      List<String> listStrings = new ArrayList<>();
      listStrings.add("TEST");
      List<Integer> listInteger = new ArrayList<>();
      listInteger.add(1);
      tryIt(listStrings);
      tryIt(listStrings, listInteger);
    }
}