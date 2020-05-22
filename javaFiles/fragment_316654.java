import java.util.Scanner;

enum GoingState {
   TO_HOME,
   TO_WORK,
   TO_SHOP, 
}

public class StateGame{

    public static GoingState state = GoingState.TO_WORK;

    public static void main(String args[]){
        Scanner scanIn = new Scanner(System.in);
        System.out.println("Where do you want to go?");
        if(scanIn.nextLine().toLowerCase().contains("home")){
            state = GoingState.TO_HOME;
            System.out.println("Going home.");
        }
        else if(scanIn.nextLine().toLowerCase().contains("work")){
            state = GoingState.TO_WORK;
            System.out.println("Going to work.");
        }
        else if(scanIn.nextLine().toLowerCase().contains("shop")){
            state = GoingState.TO_SHOP;
            System.out.println("Going to the shop.");
        }
        else{
            System.out.println("No valid input");
        }
    }
}