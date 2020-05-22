import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandPeopleMain {

    public static void main(String[] args) {
        System.out.println(lineUpLeft(10));
        System.out.println(lineUpRight(10));
    }

    public static List<Integer> lineUpLeft(int numPeople){
        Random rand = new Random();
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i < numPeople; i++){
            boolean person = rand.nextBoolean();
            if(person){
                list.add(1);
            }
        }
        for(int i=list.size(); i < numPeople; i++){
            list.add(0);
        }

        return list;
    }

    public static List<Integer> lineUpRight(int numPeople){
        Random rand = new Random();
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i < numPeople; i++){
            boolean person = rand.nextBoolean();
            if(person){
                list.add(1);
            }
        }
        for(int i=list.size(); i < numPeople; i++){
            list.add(0, 0);
        }
        return list;
    }

}