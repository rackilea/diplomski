package proGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HelloWorldGUI2 {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showGUI(args);
            }
        });
    }

    public static void showGUI(String[] args) {
        JPanel displayPanel = new JPanel();
        JButton okButton = new JButton("New Word Combo"); // Create new button
        okButton.setFont(new Font("Malina Light", Font.TRUETYPE_FONT, 14)); // Assign     custom font to new button
        final JLabel jLab = new JLabel();
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLab.setText(wordGen());
            }
        });

        //random sentence is set above, see jLab.setText(wordGen())
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(okButton, BorderLayout.SOUTH);
        content.add(jLab, BorderLayout.NORTH);

        JFrame window = new JFrame("GUI Test"); // Declaring the variable 'window'     to type JFrame and sets it to refer to a new window object within the statement
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(250, 150);
        window.setLocation(100, 100);
        window.setVisible(true);

    }

    public static String wordGen() {
        // Make three sets of words to choose from
        String[] wordListOne = {"24/7", "Terrific", "Time-tested", "Returned", "Tried", "Intepreted", "Ebay", "Large", "Small", "Medium"};
        String[] wordListTwo = {"Oriented", "Shared", "Aligned", "Targeted", "Leveraged", "Charged", "Networked", "Centric", "Distributed", "Postioned"};
        String[] wordListThree = {"Bush-beater", "Pikestaff", "Placket-racket", "Hammer-handle", "Quim-wedge", "Creamstick", "Tug-mutton", "Kennel-raker", "Testicles", "Penis", "Vagina", "Breasts", "TallyWhacker", "Johnson", "Meat", "ClamFist", "Binlid"};

        //find out how many words are in each list
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        //generate three random numbers
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        //now build a phrase
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        return phrase;
    }


}