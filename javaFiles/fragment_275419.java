import java.util.Scanner;

public class App {
public static void main(String[] args){
    //creating scanner object
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your sex (male or female): ");
    String sex = in.next(); 
    System.out.println("Thank you, you entered " + sex );

    //new scanner
    System.out.println("Are you a child or adult: ");
    String age = in.next();
    System.out.println("You are a " + sex + " " + age);

    if(age.equals("child")) {
        System.out.println("children");
    }
    else if(age.equals("adult")) {
        System.out.println("adults");
    }

    }
    }