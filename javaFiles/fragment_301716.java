import java.util.Arrays;
import java.util.stream.Stream;

class Main {
  public static void main(String[] args) {
    String numbersString = "12345";

    int[] numbersIntArray = Stream.of(numbersString.split("")).mapToInt(Integer::parseInt).toArray(); 

    System.out.println(Arrays.toString(numbersIntArray)); // [1, 2, 3, 4, 5]
  }
}