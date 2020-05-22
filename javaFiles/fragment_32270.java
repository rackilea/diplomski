import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class events {

    public static void main (String args[]) {
        Time timeObject = new Time();

        JFrame mainJFrame;
        mainJFrame = new JFrame();
        // Coding by magic!
        //mainJFrame.setLayout(BorderLayout());
        mainJFrame.setLayout(new BorderLayout());
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // don't do this, just call pack() later
        //mainJFrame.setSize(600,400);
        mainJFrame.setLayout(new BorderLayout());
        mainJFrame.setTitle("Travel Agent System");
        mainJFrame.setBackground(Color.BLUE);

        timeObject.selectButton();
        mainJFrame.add(timeObject.getGUI());

        mainJFrame.pack();
        // should be last.
        mainJFrame.setVisible(true);
    }
}

class Time {

    private JPanel buttonPanel;

    // don't use static unless necessary - it is not necessary.
    //public static void selectButton() {
    public void selectButton() {
        JButton timeButton = new JButton("Time");
        JButton moneyButton = new JButton("Money");
        JButton hotelButton = new JButton("Hotel");
        JButton exitButton = new JButton("Exit");
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.RED);
        buttonPanel.add(timeButton);
        buttonPanel.add(moneyButton);
        buttonPanel.add(hotelButton);
        buttonPanel.add(exitButton);
    }

    public JComponent getGUI() {
        return buttonPanel;
    }
}