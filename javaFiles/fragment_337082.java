package sof;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyComponent());
        frame.setSize(260, 280);
        frame.setVisible(true);
    }
}

class MyComponent extends JComponent {
    public void paint(Graphics g) {
        int height = 120;
        int width = 120;
        g.setColor(Color.black);
        g.drawOval(60, 60, width, height);
        g.drawRect(60, 60, width, height);
        g.drawLine(0,0,50,50);
    }
}