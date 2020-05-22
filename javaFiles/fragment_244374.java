import java.util.Scanner;

public class VirtualZoo {

    public static void main(String[] args) {
// Options
        final int catType = 0,
                dogType = 1,
                duckType = 2,
                exit = -1;

// create Scanner
        Scanner input;
        input = new Scanner(System.in);
        int userInput;
        System.out.println("Welcome to the Zoo");
        System.out.println("Pick select an animal to visit");
        System.out.println("=================================");
        System.out.println("===========MAIN MENU=============");
        System.out.println("=================================");
        System.out.println("==  " + catType + ") Cat    ===================");
        System.out.println("==  " + dogType + ") Dog    ===================");
        System.out.println("==  " + duckType + ") Duck   ===================");
        System.out.println("== " + exit + ") EXIT   ===================");
        System.out.println("=================================");
        do {
            System.out.println();
            System.out.println();
            System.out.println("Input  : ");
            Scanner sc = new Scanner(System.in);
            userInput = sc.nextInt();

            Animal animalSelected = null;

            switch (userInput) {
                case 0:
                    animalSelected = new Cat();
                    break;
                case 1:
                    animalSelected = new Dog();
                    break;
                case 2:
                    animalSelected = new Duck();
                    break;
                case -1:
                    System.out.println("\n" + "Thank you for visiting the Virtual Zoo" + "\n" + "Goodbye!");
                    break;
                default:
                    break;
            }

            if (animalSelected != null) {
                System.out.println(animalSelected);
            }
        } while (userInput != -1);
    }
}