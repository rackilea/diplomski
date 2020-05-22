import java.util.Scanner;

public class ageProgram {
    public static void main(String[]args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter your birth year");
        int yearBirth = keyboard.nextInt();
        System.out.println("enter a (future) year");
        int yearTo = keyboard.nextInt();

        ageCalculator agecalculator = new ageCalculator(yearBirth, yearTo);

        if (yearBirth > yearTo) {
            System.out.format("You will be born in %s years", agecalculator.getYear());
        } else {
            System.out.format("You are %s years old", agecalculator.getYear());
        }
    }
}