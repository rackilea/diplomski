import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class BorderLayoutExample {

    public static void main(String[] args) {
        JTextArea area = new JTextArea(15, 40);
        JFrame frm = new JFrame("Horizontal resizing");
        // not required, because the default layout here is the BorderLayout.
        // but in common case you probably need to do it.
        frm.setLayout(new BorderLayout());
        // Use BorderLayout.SOUTH - when you want that the top space will not be unused.
        frm.add(new JScrollPane(area), BorderLayout.NORTH);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}