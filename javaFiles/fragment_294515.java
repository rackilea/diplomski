import java.util.Scanner;

public class PineTreeUpgrade {
    static int numSections;
    static int sectionSize;
    static int gridSize;

    public static void main(String[] args) {
        askTheUserForInput();
        System.out.println();
        System.out.println("Here is your amazing creation! How artistic!");
        for(int x = 0; x < gridSize; x++){
            printTree();
            printStem();
            System.out.println();
        }
    }

    public static void askTheUserForInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hello, user!");
        System.out.println("How many section would you like in your pine tree?");
        numSections = userInput.nextInt();
        System.out.println("Great! How big would you like each section to be?");
        sectionSize = userInput.nextInt();
        System.out.println("What grid size do you want?");
        gridSize = userInput.nextInt();
    }

    public static void printTree() {
        for (int k = 0; k < numSections; k++) {
            //prints the next section, each one increasing in size
            for(int i = 0; i < sectionSize; i++) {
                //prints the spaces and number of stars in each section
                for(int x = 0; x < gridSize; x++){
                    for (int j = i; j < (sectionSize - 1) + (numSections - 1) - k; j++){
                        System.out.print(" ");
                    }

                    System.out.print("/");

                    for (int j = 0; j < i + k; j++) {
                        System.out.print("*");
                    }

                    System.out.print("*");

                    for (int j = 0; j < i + k; j++) {
                        System.out.print("*");
                    }

                    System.out.print("\\");
                    int width = 2 * (sectionSize + numSections - 1) + 1;
                    if(x != gridSize - 1){
                        for(int y = sectionSize + numSections + k + i; y < width; y++)
                            System.out.print(" ");
                        System.out.print(" ");
                    }
                }
                System.out.println();

            }
        }

    }

    public static void printStem() {
        for(int i = 0; i < 2; i++) {
            for(int x = 0; x < gridSize; x++){
                for (int j = 0; j < (sectionSize - 1) + (numSections -1) + 1; j++)
                    System.out.print(" ");

                System.out.print("|");

                if(x != gridSize - 1)
                    for (int j = 0; j <= sectionSize + numSections; j++)
                        System.out.print(" ");
            }

            System.out.println();

        }

        for (int i = 0; i < 1; i++) {

            for(int x = 0; x < gridSize; x++){
                for (int j = 0; j < (sectionSize - 1) + (numSections -1); j++)
                    System.out.print(" ");

                System.out.print("___");

                if(x != gridSize - 1)
                    for (int j = 0; j < sectionSize + numSections; j++) 
                        System.out.print(" ");
            }

        }
    }
}