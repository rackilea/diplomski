package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.*;

public class Main {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextPane textPane = new JTextPane();

    JButton button = new JButton("Test");

    public Main() {
        frame.setTitle("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(200, 200));

        panel.add(textPane, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        textPane.addStyle("negra", null);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StyledDocument doc = textPane.getStyledDocument();
                int start = textPane.getSelectionStart();
                int end = textPane.getSelectionEnd();
                if (start == end) { // No selection, cursor position.
                    return;
                }
                if (start > end) { // Backwards selection?
                    int life = start;
                    start = end;
                    end = life;
                }
                Style style = textPane.getStyle("negra");

                // I think this is what you need
                if (StyleConstants.isBold(style)) {
                    StyleConstants.setBold(style, false);
                } else {
                    StyleConstants.setBold(style, true);
                }
                doc.setCharacterAttributes(start, end - start, style, false);
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main();
            }
        });

    }
}