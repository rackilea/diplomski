//UpcaseFilter.java
//A simple DocumentFilter that maps lowercase letters to uppercase.

import javax.swing.*;
import javax.swing.text.*;

public class UpcaseFilter extends DocumentFilter {

    public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String text, AttributeSet attr) throws BadLocationException {
        fb.insertString(offset, text.toUpperCase(), attr);
    }

    // no need to override remove(): inherited version allows all removals
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String text, AttributeSet attr) throws BadLocationException {
        fb.replace(offset, length, text.toUpperCase(), attr);
    }

    public static void main(String[] args) {
        DocumentFilter dfilter = new UpcaseFilter();

        JTextArea jta = new JTextArea();
        JTextField jtf = new JTextField();
        ((AbstractDocument) jta.getDocument()).setDocumentFilter(dfilter);
        ((AbstractDocument) jtf.getDocument()).setDocumentFilter(dfilter);

        JFrame frame = new JFrame("UpcaseFilter");
        frame.getContentPane().add(jta, java.awt.BorderLayout.CENTER);
        frame.getContentPane().add(jtf, java.awt.BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 120);
        frame.setVisible(true);
    }
}