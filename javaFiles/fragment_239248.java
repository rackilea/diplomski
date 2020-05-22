import java.util.*;

public class mistakes {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Arraylist <Integer> inputs = new Arraylist <Integer> ();

        for(int i=1; i<6; i++){
            System.out.println("How many did participant " + i + " make on interface 1? ");
            inputs.add(input.nextInt());
        }          
    }
}