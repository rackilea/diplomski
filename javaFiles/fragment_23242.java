package snippet;

import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

public class JTreeTest extends JFrame {
    private final class StrikeoutCellRenderer extends DefaultTreeCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                boolean leaf, int row, boolean hasFocus) {
            Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            Font font = c.getFont();
            Map attributes = font.getAttributes();
            if(sel)
                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            else
                attributes.remove(TextAttribute.STRIKETHROUGH);
            Font newFont = new Font(attributes);
            c.setFont(newFont);
            return c;
        }

    }

    private static final long serialVersionUID = 1L;

    public JTreeTest() {
        super(JTreeTest.class.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JTree tree = new JTree();
        tree.setCellRenderer(new StrikeoutCellRenderer());
        add(tree);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
                JTreeTest t = new JTreeTest();
                t.setVisible(true);
            }
        });
    }
}