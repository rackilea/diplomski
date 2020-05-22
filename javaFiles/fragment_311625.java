import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class JEditorPaneTest extends JFrame {
    public static void main(String[] args) {
        JEditorPaneTest t= new JEditorPaneTest();
        t.setSize(500,500);
        Container bg = t.getContentPane();
        t.createJEditorPane(bg, bg.getSize());
        t.setVisible(true);
    }

    public void createJEditorPane(Container bg, Dimension size) {
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        HTMLDocument htmlDoc = new HTMLDocument();
        HTMLEditorKit editorKit = new HTMLEditorKit();
        pane.setEditorKit(editorKit);
        pane.setSize(size);
        pane.setMinimumSize(size);
        pane.setMaximumSize(size);
        pane.setOpaque(true);
        pane.setText("<b><font face=\"Arial\" size=\"50\" align=\"center\" > Unfortunately when I display this string it is too long and doesn't wrap to new line!</font></b>");
        bg.add(pane, BorderLayout.CENTER);
    }
}