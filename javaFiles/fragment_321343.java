package com.test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBar {

    private JFrame progressFrame;
    private JProgressBar progressBar;

    /**
     * Create the application.
     */
    public ProgressBar() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        progressFrame = new JFrame();
        progressFrame.setTitle("Test progress bar");
        progressFrame.setResizable(false);
        progressFrame.setBounds(100, 100, 640, 79);
        progressFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        progressFrame.getContentPane().setLayout(null);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        progressBar.setBackground(new Color(255, 255, 255));
        progressBar.setIndeterminate(false);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(0, 128, 0));
        progressBar.setBounds(0, 0, 634, 52);

        progressFrame.getContentPane().add(progressBar);
    }

    public void showProgress() {
        initialize();
        progressFrame.setVisible(true);
    }

    public void closeProgress() {
        progressFrame.dispose();
        progressFrame.setVisible(false);
    }

    public void updatePercent(int value) {
        progressBar.setValue(value);
    }
}