import java.util.ArrayList;
import java.util.Random;

public class ComputerChoose {

    static ArrayList<Integer> computer_number = new ArrayList<>();

    public static ArrayList<Integer> getTheNumber() {
        Random random = new Random();

        for(int times=0; times<5; times++) {
            computer_number.add(random.nextInt(20) + 1);
        }

        return computer_number;
    }
}