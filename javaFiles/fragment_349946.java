import javax.swing.*;

public class RPS_Game {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        greeting();
    }

    public static void greeting() {
        String greet = "This program will play 3 games of rock paper scissors with you.\n\n" +
                "It will ask you for your choice and then randomly generate a choice for the computer.\n\n" +
                "After all 3 games you will be shown the total results.";
        JOptionPane.showMessageDialog(null, greet, "Greeting", 1);
    }
}