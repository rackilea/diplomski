import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void tryIt(List... lists) {
    System.out.println("You insert " + lists.length + " lists.");
    if (lists.length>2)
      for (Object obj : lists[2]) {
        System.out.println(obj);
      }
  }
  public static void main(String[] args) {
    List<String> listStrings = new ArrayList<>();
    listStrings.add("TEST");
    List<Integer> listInteger = new ArrayList<>();
    listInteger.add(1);
    List<String> anotherStringList = new ArrayList<>();
    anotherStringList.add("First value.");
    anotherStringList.add("Second value.");
    anotherStringList.add("Third value.");
    tryIt(listStrings);
    tryIt(listStrings, listInteger);
    tryIt(listInteger, listStrings, anotherStringList);
    }
}