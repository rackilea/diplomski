import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NonRepeatRandom {
    public static void main(String[] args){
        final int low = 1;
        Set<Integer> set = new HashSet<Integer>();
        Random rand = new Random();  

        while (set.size() < 20) {
            set.add(rand.nextInt(1000) + low); // set bound between 1 and 1000
        }
        System.out.println(set);
    }
}