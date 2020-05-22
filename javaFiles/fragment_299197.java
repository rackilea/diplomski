import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI1 {

    JTextField t; 
    JButton count;
    int a;
    JFrame frame;

    public GUI1(){
        frame = new JFrame();
        t = new JTextField("", 15);
        count = new JButton("count");
        JTextField x = new JTextField("", 15);
        x.setEditable(false);

        count.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int count = t.getText().length();
                System.out.println(count);
                x.setText(t.getText());
            }
        });

        frame.setTitle("Character count");
        frame.setLayout(new FlowLayout());

        frame.add(x);
        frame.add(t);
        frame.add(count);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main (String args[]) {
        new GUI1();
    }
}