import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Sequence {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> result = new ArrayList<>();
        int num = -1;
        while (num != 0) {
            num = r.nextInt(10);
            result.add(num);
        }
        System.out.printf("The sequence is: %s%n", result);
        System.out.printf("The length of the sequence is: %d%n", result.size());
    }
}