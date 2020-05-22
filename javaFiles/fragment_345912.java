import java.util.Scanner;

public class Learning {

public static void main(String[] args) {

String isCorrect = "noValue";
//If isCorrect equals noValue, keep going until it equals yes or Yes
while(isCorrect.equals("noValue")&&(!isCorrect.equals("yes")||!isCorrect.equals("Yes"))) {
    System.out.println("Hello, What is your name?");
    //You don't really need two scanners if they are both for the same thing
    Scanner scanner = new Scanner(System.in);
    String yourName = scanner.nextLine();
    System.out.println("Is: " +yourName + " your name?");

    isCorrect = scanner.nextLine();
    //include the if and else statements so the program knows what to say
    //and if it should repeat or not
    if(isCorrect.equals("yes")||isCorrect.equals("Yes")) {
        System.out.println("Thank you, please proceed with the quiz!");
    } else {
        System.out.println("Please try again");
        isCorrect = "noValue";
    }
}
//Continue with the quiz here!
}
}