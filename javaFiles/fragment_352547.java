import java.util.Arrays;
import java.util.List;

public class StringTest {
  public static void main(String[] args) {
    List<String> strings = Arrays.asList("a", "b", "c", "d");
    strings.replaceAll(s -> "D"+s);
    System.out.println(strings);
  }
}