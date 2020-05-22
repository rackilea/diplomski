package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Form extends JFrame {
    private final int width;
    private final int height;
    private final int posx;
    private final int posy;
    private final String title;

    public Form(int width, int height, String title) {
        // call parent constructor
        super();

        // set size
        this.width = width;
        this.height = height;

        // set title
        this.title = title;

        // get position(x,y)
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Double x = (screen.getWidth() - this.width) / 2;
        Double y = (screen.getHeight() - this.height) / 2;
        posx = x.intValue();
        posy = y.intValue();

        // add components
        JLabel points1Label = new JLabel("The Rookie (aka You)");
        points1Label.setBounds(10, 50, points1Label.getPreferredSize().width,
            points1Label.getPreferredSize().height);
        this.getContentPane().add(points1Label);

        // set form properties
        this.setLayout(null);
        this.setSize(width, height);
        this.setLocation(posx, posy);
        this.setResizable(false);
        this.setTitle(title);
        this.setVisible(true);
    }

    public void addComponent(Component c, int posx, int posy) {
        c.setLocation(posx, posy);
        this.getContentPane().add(c, BorderLayout.CENTER);
    }
}