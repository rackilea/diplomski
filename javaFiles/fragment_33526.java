package practise;

import java.util.Scanner;

public class scanccls {

    public static void main(String[] args) {

        System.out.println("Enter your name:"); 
        Scanner scan = new Scanner(System.in);
        String name="";

        name+=scan.nextLine();
        scan.close();

        System.out.println("Your name is :"+name); 

    }

}