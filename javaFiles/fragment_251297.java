import java.util.Arrays;
import java.util.Random;

public class Rnd {

    public static void main(String[] args) {
        Random random = new Random();
        int[][] populations = new int[300][1];

        for(int i = 0; i < 300; i++) {
            for(int j = 0; j < 1; j++) {
                populations[i][j] = random.nextInt(4);
            }
        }

        System.out.println(Arrays.toString(populations));
    }
}