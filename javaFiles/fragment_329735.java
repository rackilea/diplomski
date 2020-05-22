package tests;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainWindow extends JFrame {

    public MainWindow() {

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");

        MyListener ml1 = new MyListener(label1);
        MyListener ml2 = new MyListener(label2);

        button1.addActionListener(ml1);
        button2.addActionListener(ml2);

        getContentPane().setLayout(new GridLayout(0, 1));

        getContentPane().add(label1);
        getContentPane().add(label2);
        getContentPane().add(button1);
        getContentPane().add(button2);

        pack();
        setLocation(600, 300);
        setVisible(true);

    }

    private class MyListener implements ActionListener {

        JLabel label;

        private MyListener(JLabel label) {
            this.label = label;
        }

        @Override
        public void actionPerformed(ActionEvent ev) {
            label.setVisible(!label.isVisible());
        }

    }

}