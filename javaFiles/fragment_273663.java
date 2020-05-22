import java.util.Scanner;

public class ParseInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert E for Shutdown, X for Mute and Numbers between 1 to 10 for Volume");
        String input = in.nextLine().trim(); // read the entire line after removing spaces if any, then parse it

        if(input.length()>0){ // that means the user entered something
            try{
                int volumeValue = Integer.parseInt(input); // if it's not a number, it will throw exception that will be handled in the catch block
                if(volumeValue>=1 && volumeValue<=10){// then evaluate the value
                    System.out.println("This is a Volume");
                }
                else{
                    System.out.println("Incorrect Volume Value");
                }
            }catch(NumberFormatException e){ // if you reach this block that means it's not a number
                if(input.equalsIgnoreCase("e")){ // to accept both uppercase and lowercase
                    System.out.println("Shutting Down");
                }
                else if(input.equalsIgnoreCase("x")){ 
                    System.out.println("Mute");
                }
                else{
                    System.out.println("Incorrect Input");
                }
            }
        }
        else{
            System.out.println("You have NOT entered anything!");
        }
    }

}