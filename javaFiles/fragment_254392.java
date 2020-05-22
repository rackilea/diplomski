public class FirstClass {
public static int decision;     
public static void main(String[] args) { 

Scanner input = new Scanner(System.in);
System.out.println("Please enter ");
decision = input.nextInt();

System.out.println(decision);

SecondClass.breadCals();    //gets the method 
}}