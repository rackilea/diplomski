import java.util.ArrayList;

public class Exercise {

    private static ArrayList<Integer> list = new ArrayList<Integer>(); // You can initialize your ArrayList here as well

    public static void main(String[] args) {

        String userInput = null;
        int number = 0;

        do{
            // Read inputs as long as user did not entered 'stop'
            userInput = readUserInput();
            number = createNumberFromColor(userInput);
            // add the number to the list if it's not 0
            if (number!=0) {
                list.add(number);   
            }
        }while (!userInput.equals("stop"));

        // If you want afterwards you can print the list elements
        System.out.println("The list contains:");
        for (int i=0; i<list.size(); i++) {
            System.out.print(""+list.get(i)+" ");
        }
        System.out.println();
    }

    private static String readUserInput(){
        // This is an easier way to read the user input from the console
        // than using the Scanner class, which needs to be closed etc...
        return System.console().readLine();
    }

    private static int createNumberFromColor(String input){
        switch (input) {

            // Add your own cases here, for example case "red": return 1, etc...

            case "blue":
            return 5;

            case "yellow":
            return 3;

            // If the input was not a known color then return 0
            default:
            return 0;
        }
    }
}