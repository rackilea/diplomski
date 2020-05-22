import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Perm2 {

  public static void main(String[] args) {
    List<String> listA = Arrays.asList("1", "2", "3");
    List<String> listB = Arrays.asList("a", "b", "c");

    List<String> result = perm2(listA, 2, listB, 1);
    result.forEach(System.out::println);
    System.out.println("--- count = " + result.size());
  }

  private static List<String> perm2(List<String> listA, int numA, List<String> listB, int numB) {
    if (numA == 0 && numB == 0) return Collections.singletonList("");

    List<String> forSelect = new ArrayList<>();
    if (numA > 0) forSelect.addAll(listA);
    if (numB > 0) forSelect.addAll(listB);

    List<String> result = new ArrayList<>();
    for (String elem : forSelect) {
      List<String> newListA = without(listA, elem);
      int newNumA = numA - (listA.contains(elem) ? 1 : 0);
      List<String> newListB = without(listB, elem);
      int newNumB = numB - (listB.contains(elem) ? 1 : 0);
      result.addAll(
            perm2(newListA, newNumA, newListB, newNumB).stream()
                  .map(s -> elem + s)
                  .collect(toList()));
    }
    return result;
  }

  private static List<String> without(List<String> list, String elem) {
    return list.stream().filter(e -> e != elem).collect(toList());
  }

}