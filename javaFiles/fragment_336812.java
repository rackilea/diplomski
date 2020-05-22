import java.util.Scanner;
public class lol {
    public static void main (String args[]){
    //take user info 
    Scanner sc = new Scanner(System.in);


    int candy = 12;
    int kids = 4;
    int answer = candy / kids;
    String answer2 = "No Candy";

    System.out.println("Are youkids good or bad?");
    System.out.println("[1] Good = true");
    System.out.println("[2] Bad = false");
    String a = sc.nextLine();
    boolean userInput = Boolean.parseBoolean(a);

    if(userInput== false){
        System.out.println(answer2);
        System.out.println("Try again tomorrow!");
    }
    else{
        System.out.println("Good Job");
        System.out.println("You get" +answer+"pieces.");
    }
}