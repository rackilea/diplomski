import java.util.Scanner;

public class Adventure {
    public static final int menuStars = 65;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String firstName = "";
        String lastName = "";

        boolean firstNameLegal = false;
        boolean lastNameLegal = false;

        // Entering first name
        while (!firstNameLegal) {
            System.out.println("Please enter your first name.");
            firstName = input.nextLine();

            if (!firstName.equals(" "))
                firstNameLegal = true;
            else
                System.out.println("Please enter a first name of at least 1 character.");  
        }

        // Entering last name
        while(!lastNameLegal){
            System.out.println("Please enter your last name.");
            lastName = input.nextLine();

            if(!lastName.equals(" "))
                lastNameLegal = true;
            else
                System.out.println("Please enter a last name of at least 1 character.");
        }

        System.out.println("You have entered " + firstName +" " + lastName);
    }
}