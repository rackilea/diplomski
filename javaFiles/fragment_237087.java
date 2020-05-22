import java.util.Scanner;

public class Question1 {

    public static void main (String[]args){
        String major;
        Scanner read = new Scanner(System.in);
        System.out.print("Enter character : " );
        major=read.nextLine(); // better nextLine, because otherwise the press of "Enter" will not be registered.
        mn(major);
    }

    public static void mn(String major){ //method 

        if (major.equals("M")){ 
            System.out.println("Mathematic");
        }
        else if (major.equals("C")){ 
            System.out.println("Computer Science");
        }
        else if (major.equals("I")){
            System.out.println("Information Technology");
        }
        else {
            System.out.println("Invalid Input");
        }            
    }
}