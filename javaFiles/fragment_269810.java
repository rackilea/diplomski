package test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Animation extends JPanel {
    JLabel l1 = new JLabel(new ImageIcon("tom1.png"));
    JLabel l2 = new JLabel(new ImageIcon("tom2.png"));
    JLabel l3 = new JLabel(new ImageIcon("tom3.png"));
    JLabel l4 = new JLabel(new ImageIcon("tom4.png"));
    JLabel l5 = new JLabel(new ImageIcon("tom5.png"));
    JButton b1 = new JButton("HAHA");
    JButton b2 = new JButton();
    JPanel panel = new JPanel();
    boolean isthere = false;

    public Animation() {
        setLayout(new BorderLayout());
        Timer time = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!isthere) {
                    System.out.println("paint");
                    add(b1, BorderLayout.CENTER);
                    repaint();
                    revalidate();

                    isthere = !isthere;
                } else {

                    System.out.println("remove");
                    removeAll();
                    repaint();
                    revalidate();
                    isthere = !isthere;
                }

            }
        });
        time.start();

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Animation());
        frame.setVisible(true);
        frame.setSize(1000, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}