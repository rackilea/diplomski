import java.util.*;
import java.util.stream.Collectors;

public class Defensive {

  public static void main(String[] args) {
    Map<String, Column> original = new HashMap<>();
    original.put("foo", new Column());
    original.put("bar", new Column());

    Map<String, Column> copy = original.entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getKey,
                                  e -> new Column(e.getValue())));

    System.out.println(original);
    System.out.println(copy);
  }

  static class Column {
    public Column() {}
    public Column(Column c) {}
  }
}