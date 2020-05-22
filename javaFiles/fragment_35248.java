import javax.swing.*;
import java.util.*;
import java.io.*;

public class try1 {

    private static JPanel panel = new JPanel();
    private static try2 testing = new try2();
    public static Integer testnum;

    public static void main(String[] args) {
        testnum = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter The Amount Of Test To Be Calculated Below "));
        tryMe();
    }

    public static void tryMe() {
        int userInput = 0;

        if (userInput == JOptionPane.YES_OPTION) {
            for (int count = 1; count <= testnum; count++) {
                String userInputString = JOptionPane.showInputDialog(null, " PLEASE ENTER ALL THE FOLLOWING TEST GRADES TO CALCULATE ");
                int value = Integer.parseInt(userInputString);
                testing.addInput(value); // sending this to my class.
            }

            JOptionPane.showMessageDialog(null, String.valueOf(testing.getAvg()));
        }

        if (userInput == JOptionPane.NO_OPTION) {
            System.exit(0);

        }
    }
}

class try2 {

    public static ArrayList<Integer> userInput = new ArrayList<Integer>();
    public static double avg;

    public try2() {
    }

    public void addInput(int value) {
        userInput.add(value);
    }

    public try2(int i) {

        userInput.add(i);

    }

    public double getAvg() {
        double sum = 0;
        for (Integer value : userInput) {
            sum += value;
        }
        return sum / userInput.size();
    }
}