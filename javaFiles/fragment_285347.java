import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JButton button = new JButton("Click Me");

        changeButtonText(button);
    }

    public static void changeButtonText(JButton button){
        button.setText("I've been clicked");
    }
}