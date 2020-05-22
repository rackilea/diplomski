package com.firstFrameApp.helloworld;

import javax.swing.*;
import javax.swing.JFrame;

public class helloWorld
{
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame0 = new JFrame("Hello World Example");

        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}