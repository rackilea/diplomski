import java.util.*;
import java.lang.*;

public class Planner{

public static void main(String[] args) {
    System.out.println("Planner initialized.");
    System.out.println("Reading settings..");
    System.out.println("Assessing environment..");
    System.out.println("Gathering tools..");
    System.out.println("****************************************");
    System.out.println("");
    intro();
}

public static void intro() {
    Scanner fn = new Scanner(System.in);

    System.out.println("Welcome to the vacation planner.");
    System.out.println("What is your first name?");
    String name = fn.nextLine();
    System.out.println("What is your last name?");
    String lastname = fn.nextLine();
    System.out.println("Welcome, " + name + " " + lastname);
    System.out.println(". Where are you traveling to?");
    String traveling = fn.nextLine();
    System.out.println("Excellent. " + traveling + " it is.");
    System.out.println("*****************************************");
    System.out.println("");
    calc();
}

public static void calc() {
     Scanner scanner = new Scanner(System.in);

    System.out.println("How many days are you planning to spend away?");
    String x = scanner.nextLine();
    System.out.println("How much money, in U.S. dollars, are you planning to spend?");
    String m = scanner.nextLine();
    System.out.println("What is the three-letter currency symbol for your destination?(Google may be required)");
    String i = scanner.nextLine();
    System.out.println("How many " + i + " are there in USD? (Google may be required)");
    String o = scanner.nextLine();
    System.out.println("");


    float t = Float.parseFloat(x);
    float r = Float.parseFloat(m);
    float k = Float.parseFloat(o);


    //To calculate the amount of hours
    float n = t * 24;
    //To calculate the amount of minutes
    float u = (t * 24) * 60;
    //To calculate daily budget
    float y = t / r;
    // To calculate currency exchange
    float e = k * r;
    //To calculate budget in alt currency
    float q = t / e;

    System.out.println("If you are travelling for " + t + " days, that is the same as " + n + " hours, or " + u + " minutes.");
    System.out.println("If you are going to spend " + r + " U.S. dollars per day, you can spend" + y + " dollars per day.");
    System.out.println("Your total budget in " + i + "is " + e + i + ", which, per day, is " + q + i);
    System.out.println("****************************************");
    System.out.println("");
 }
}