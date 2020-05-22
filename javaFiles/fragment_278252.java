package com.java.demo;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Frame");
        frame.setLayout(new GridBagLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setPreferredSize(new Dimension(250, 150));
        frame.setMaximumSize(new Dimension(250, 150));
        frame.setMinimumSize(new Dimension(250, 150));
        JLabel label = new JLabel(new Date().toString());
        frame.getContentPane().add(label);
        frame.setVisible(true);

    }

}