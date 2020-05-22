package com.stackoverflow.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Start extends JFrame implements ActionListener {
    JButton Polski, English; // nazwy przycisków
    JLabel jezyk, language;
    static JLabel wybór;
    private JDialog messageDialog;
    private JLabel messageLabel;

    public Start() {
        getContentPane().setBackground(Color.BLUE);
        setSize(330, 170);// rozmiar
        setTitle("MathCalc v0.1 by Majkel");
        setLayout(null);

        messageDialog = new JDialog(this);
        messageLabel = new JLabel("", JLabel.CENTER);
        messageDialog.setSize(200, 200);
        messageDialog.getContentPane().add(messageLabel);

        jezyk = new JLabel("Choose language:");
        jezyk.setBounds(40, 10, 200, 40);
        add(jezyk);

        Polski = new JButton("Polski");
        Polski.setBounds(40, 50, 100, 30);
        add(Polski);
        Polski.addActionListener(this);

        English = new JButton("English");
        English.setBounds(150, 50, 100, 30);
        add(English);
        English.addActionListener(this);

        wybór = new JLabel("Choose");
        wybór.setBounds(40, 90, 400, 30);
        add(wybór);

    }

    public static void main(String[] args) {
        System.out.println("Choose language:");
        Start okno1 = new Start();

        okno1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object klik = e.getSource();
        if (klik == Polski) {
            wybór.setText("Wybrałeś język Polski.".toString());
            hideThisShowNewFrameAfterDelay(1500);
            showMessageDialog("Wybrałeś język Polski");
            System.out.println("Wybrałeś język Polski.");
        }

        else if (klik == English) {
            wybór.setText("You have chosen English.".toString());
            hideThisShowNewFrameAfterDelay(1500);
            showMessageDialog("You have chosen English.");
            System.out.println("You have chosen English.");
        }
    }

    private void showMessageDialog(String message) {
        messageLabel.setText(message);
        messageDialog.setVisible(true);
    }

    private void hideMessageDialog() {
        messageDialog.dispose();
    }

    private void hideThisShowNewFrameAfterDelay(int milliseconds) {
        Timer timer = new Timer(milliseconds, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hideMessageDialog();
                Start.this.setVisible(false);
                new czynnośćPL().setVisible(true);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

}