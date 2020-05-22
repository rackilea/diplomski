package com.ggl.testing;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

public class HugeTextArea implements Runnable {

    private DefaultStyledDocument   document;

    private JFrame                  frame;

    private JTextArea               textArea;

    public HugeTextArea() {
        this.document = new DefaultStyledDocument();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                buildLongString(400000);
            }
        };
        new Thread(runnable).start();
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setTitle("Huge Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(document);
        textArea.setLineWrap(true);
        frame.add(new JScrollPane(textArea));

        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private void buildLongString(int length) {
        Random random = new Random();
        String[] chars = { "s", "t", "a", "y", " " };
        for (int i = 0; i < length; i++) {
            try {
                document.insertString(document.getLength(),
                        chars[random.nextInt(chars.length)],
                        null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new HugeTextArea());
    }

}