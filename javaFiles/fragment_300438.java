import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class ALineBorder {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Line Borders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button1 = new JButton("Button1");
        button1.setBorder( new EmptyBorder( 8, 8, 8, 8 ) );
        JButton button2 = new JButton("Button2");
        JButton button3 = new JButton("Button3");
        button3.setBorder( new EmptyBorder( 16, 16, 16, 16 ) );
        Container contentPane = frame.getContentPane();
        contentPane.add(button1, BorderLayout.WEST);
        contentPane.add(button2, BorderLayout.CENTER);
        contentPane.add(button3, BorderLayout.EAST);
        frame.pack();
        frame.setSize(300, frame.getHeight());
        frame.setVisible(true);
    }

}