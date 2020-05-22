//new ImageIcon(getClass().getResource("/res/image-file_name"));**

package StackOverflowProblemSets;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by HACKER on 05/06/2017.
 * https://stackoverflow.com/questions/44370545/mouselistener-doesnt-work-
   the-first-time-and-there-are-other-errors
 */

class MainFrame extends JFrame {

    JButton button2 = new JButton("Go to Frame 2", new 
ImageIcon(getClass().getResource("/res/ic_action_maps_blue.png")));


public MainFrame() {
    setSize(500, 500);
    getContentPane().setBackground(Color.RED);
    setLayout(new FlowLayout());

    add(button2);

    button2.addMouseListener(new MouseAdapter() {
        /**
         * {@inheritDoc}
         *
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            setVisible(false);
            new Sample2().setVisible(true);
        }
    });}}



public class Sample2 extends JFrame {

JButton button4;

public Sample2() {

    setSize(500, 600);
    setLayout(new FlowLayout());
    getContentPane().setBackground(Color.YELLOW);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MainFrame mf = new MainFrame();
    button4 = new JButton("Button 4", new 
ImageIcon(getClass().getResource("/res/ic_action_alpha_icon_D.png")));
    add(button4);

    button4.addMouseListener(new MouseAdapter() {
        /**
         * {@inheritDoc}
         *
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("It works.");
            mf.setVisible(true);
            setVisible(false);
        }
    });
}

public static void main(String[] args) {
    Sample2 sample2 = new Sample2();
    sample2.setVisible(true);
}}