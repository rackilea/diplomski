import java.util.Scanner;
import java.io.*;

public class Prompter {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        String sTerm;

        System.out.print("Enter:> ");

        while(sc.hasNextLine()) {
            sTerm = sc.nextLine();
            if(sTerm.isEmpty()) {
            } else if (sTerm.startsWith("echo")) {
                sayWord(sTerm.substring(5));
            } else {
                System.out.println("Invalid command " + sTerm.split(" ")[0]);
            }
            System.out.print("Enter:> ");
        }

        sc.close();
    }

    public static void sayWord (String sTerm){

        System.out.println(sTerm);
    }
}