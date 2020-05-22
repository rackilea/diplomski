package application;

import java.util.Scanner;

public class Abc {

    public static void main(String[] args) {
        System.out.println("Some activitives...");
        System.out.println("Press 1 to start JAVAFX");

        try(Scanner input = new Scanner(System.in)){
            int one = input.nextInt();
            if(one == 1) {
                String[] inputedValue = new String[] {String.valueOf(one)};
                MainJavaFX.main(inputedValue);
                System.out.println("The user picked " + FXMLDocumentController.selectedValue);
                System.out.println("Go on and use it...");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}