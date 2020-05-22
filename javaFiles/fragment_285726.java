import java.util.Scanner;

    class animal {

    // Animal variables
    String name;
    String type;

    // Method or subroutine, something an object belonging to the class can do
    void sound() {
        System.out.println(name + " was petted! " + name + " went 'Gauuu!'");
    }

}

public class Objectmethod {

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // Creating an object under the class of Animal
        animal animal1 = new animal();
        animal1.name = "Baby Elephant Seal";
        animal1.type = "Seal";

        // Creating second animal
        animal animal2 = new animal();
        animal2.name = "Hippopotawhateveritis";
        animal2.type = "Hippopotamus or however you spell it";

        // check user input to select correct object
        while (true) {

            // Beginning prompt for user input
            System.out.println("Would you like to pet the seal, or the hippo?");

            // The code to recieve input of the user
            String select = scanner1.nextLine();

            if (select.equals("seal")) {

                // Command that the animal sounds has.
                animal1.sound();

                // Prompt if the user would like to repeat
                System.out.println("Would you like another animal?");

                // second input recieving from user
                String input = scanner2.nextLine();

                // Checks user input for yes no or random crap
                if (input.equals("yes")) {
                    continue;
                } else if (input.equals("no")) {
                    break;
                } else {
                    while (!input.equals("yes") && !input.equals("no")) {
                        System.out.println("Answer yes or no you derpface.");
                        input = scanner2.nextLine();
                    }
                }
            } else if (select.equals("hippo")) {
                animal2.sound();
                break;
            } else {
                System.out.println("You cray cray. Just pick one.");
                select = scanner1.nextLine();
            }  
        }

        System.out.println("Thank you for participating.");
    }
}