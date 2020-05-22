import java.util.Scanner;

public class TreeStructures {

    static Scanner scnr = new Scanner(System.in);
    static int height;

    public static void main(String[] args) {

        System.out.print("How tall should the top of the tree be? ");
        height = scnr.nextInt();
        System.out.println();
        if (height >= 5 && height <= 20) {
            System.out.println("Flat tree:");
            flatTree();
            System.out.println("Xmas tree:");
            xmasTree();
        } else {
            System.out.println("That's not a valid size. I can only do trees from 5 to 20");
            System.out.println("Quitting now.");
        }

    }

    public static void flatTree() {
        int width = (height * 2) - 1;
        // first for loop to print number of rows
        for (int i = 1; i <= height; i++) {
            // second for loop to print stars to create rectangle
            for (int stars = 1; stars <= width; stars++) {
                System.out.print("*");
            }
            // println to print rows in.
            System.out.println();
        }
        //first for loop to print out rows for the bottom part of tree
        for (int i = 0; i <= height / 5; i++) {
            if (height % 2 == 0) {
                for (int j = 0; j <= ((width) / 3) + 1; j++) {
                    System.out.print("*");

                }
            } else {

                //second for loop to print out width for the bottom part of the tree
                for (int j = 0; j <= (width) / 3; j++) {
                    System.out.print("*");

                }
            }
            System.out.println();
        }

    }

    public static void xmasTree() {
        int width = height * 2 - 1;
        // NESTED LOOPS
        // first for loop to print amount of rows
        for (int i = 0; i < height; i++) {
            // second for loop for print out spaces to match the tree level
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }
            // third for loop to print out stars
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // first for loop to determine amount of rows for bottom
        for (int i = 0; i <= (height-1) / 5 +1 ; i++) {
                // for loop to print the bottom part of the tree
                for (int j = 0; j <= width/3; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= (width) / 3; j++) {
                    System.out.print("*");
                }
                System.out.println();
        }

    }

}