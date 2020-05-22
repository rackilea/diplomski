import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String args[]) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);

        System.out.println(numbers.stream().mapToInt(value -> value).sum());
    }
}