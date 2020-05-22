package javaapplication1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class myClass extends JFrame{

    static JButton button = new JButton("button 1");
    static JButton button2 = new JButton("button 2");
    public static int counter = 0;

    public static void do_something() {
        counter++;
        button2.setText(Integer.toString(counter));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(button);

        button2.addActionListener(e -> do_something());
        frame.add(button2);
        frame.pack();
        frame.setVisible(true);
    }
}