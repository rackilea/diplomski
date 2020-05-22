import java.util.LinkedList;
import java.util.List;

public class Reverse {

  public static List<Integer> reverse(List<Integer> input) {
    if (input.isEmpty()) {
      return new LinkedList<Integer>();
    } else {
      Integer first = ((LinkedList<Integer>) input).removeFirst();
      List<Integer> output = reverse(input);
      output.add(first);
      return output;
    }
  }

  public static void main(String[] args) {

    List<Integer> input = new LinkedList<>();
    input.add(15);
    input.add(37);
    input.add(26);
    input.add(18);
    input.add(31);

    System.out.println("Input  : " + input);
    System.out.println("Output : " + reverse(input));
  }
}