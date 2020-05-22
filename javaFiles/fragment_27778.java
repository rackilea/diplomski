import java.util.Random;

public class arrays {
    Random random = new Random();

    public void method () {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int j = random.nextInt(20);

        if(Arrays.asList(numbers).contains(j)) {
            System.out.println("It is in the array.");
        } else {
            System.out.println("It is not in the array.");
        }
    }
}