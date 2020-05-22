package com.sandbox;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SwingSandbox {

    public static void main(String[] args) throws IOException {
        JFrame frame = buildFrame();

        JPanel pane = new JPanel();

        JButton button = new JButton();
        final JLabel label = new JLabel("0/10");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] parts = label.getText().split("/");
                int left = Integer.valueOf(parts[0]) + 1;
                int right = Integer.valueOf(parts[1]) - 1;
                label.setText(left + "/" + right);
            }
        });

        pane.add(button);
        pane.add(label);


        frame.add(pane);
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }


}