import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Example {

    public void createAndShowGUI() {    
        JRadioButton encryptButton = new JRadioButton("Encrypt");
        encryptButton.setOpaque(false);

        JRadioButton decryptButton = new JRadioButton("Decrypt");
        decryptButton.setOpaque(false);

        ButtonGroup group = new ButtonGroup();
        group.add(encryptButton);
        group.add(decryptButton);

        JPanel subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(encryptButton);
        subPanel.add(decryptButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.CYAN);
        mainPanel.add(subPanel);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example().createAndShowGUI();
            }
        });
    }

}