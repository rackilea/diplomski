package simple.concepts.com;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter day");
        String day = scan.nextLine();

        JOptionPane.showMessageDialog(null, day);
        scan.close();
    }
}