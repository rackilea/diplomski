import java.util.Scanner;
public class CoffeeBot {

static Scanner keyboard = new Scanner (System.in);

public static void main(String[] args) {


    System.out.println("Hello, what's your name?");
    String name = keyboard.next();
    System.out.println("Would you like to order some coffee, "+name+"(y/n)?");
    String response = keyboard.next();
    {
     if (response.equalsIgnoreCase("y")){
     System.out.println("Great! Lets get started.");
     System.out.println("There are 6 coffee cups in stock and each costs $2.00.");
        System.out.println("There are 8 coffee shot in stock and each costs $1.00.");
        System.out.println("How many cups of coffee would you like?");
        int cups;
        cups = keyboard.nextInt();

        {
            if (cups == 0){
            System.out.println("No cups, no coffee. Goodbye.");

            }

            if (cups < 0){
            System.out.println("Does not compute. System terminating.");
            }

            if (cups > 6){
            System.out.println("Not enough stock. Come back later.");
            }
        }
        shots(cups); //This methods calls the shots static class

}

    }
}
public static int[] shots(int num){
    int[] shots = new int[num];
    for(int i = 0; i<num;i++){
    System.out.println("How many coffee shots in cup "+(i+1)+" ?");
    shots[i] = keyboard.nextInt();  
    }
    return shots;
}
}