import java.math.*;
import java.util.Scanner;

public class Pitagor {
    public static void main (String[] args){
        System.out.println(pitagor(getIntInput("Eingabe von a  "),getIntInput("Eingabe von b")));

    }
    public static int getIntInput(String prompt){
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        return input.nextInt();
    }
    public static double pitagor (int x , int y){
        double c = Math.sqrt((x*x)+(y*y));
        return c;
    }
}