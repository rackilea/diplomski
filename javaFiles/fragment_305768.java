package test;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            JTextArea ta = new JTextArea("a\nb\nc\nd\ne\nf\ng\nh");
            ta.setEditable(false);
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            p.add(new JScrollPane(ta));
            f.add(p);
            f.setSize(100, 100);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}