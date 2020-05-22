import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

public class Tester {

    public static void main(String[] args) {
        JTextPane textpane = new JTextPane();
        textpane.setDocument(new TabDocument());
        JFrame frame = new JFrame();
        frame.getContentPane().add(textpane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(200, 200));
        frame.setVisible(true);
    }

    static class TabDocument extends DefaultStyledDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            str = str.replaceAll("\t", " ");
            super.insertString(offs, str, a);
        }
    }
}