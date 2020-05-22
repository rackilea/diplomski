package example;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUI {

    private JTextArea textArea;
    private JFrame frame;

    public GUI() {
        frame = new JFrame("Example");
        frame.setBounds(0, 0, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        frame.getContentPane().add(textArea, BorderLayout.CENTER);
    }

    public void start() {
        frame.setVisible(true);
    }

    public void appendText(String text) {
        textArea.append(text);
    }
}