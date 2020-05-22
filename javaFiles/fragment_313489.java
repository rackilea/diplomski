import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.tree.TreePath;

public class TreeNodeLocation {

    private JTree tree = new JTree();

    TreeNodeLocation() {
        JPanel p = new JPanel(new BorderLayout(2,2));

        final JTextField find = new JTextField("food:pizza");
        find.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean found = findText(find.getText());
                System.out.println(find.getText() + " found " + found);
            }
        });
        p.add(find, BorderLayout.PAGE_START);

        tree.setVisibleRowCount(8);
        for (int row=tree.getRowCount(); row>=0; row--) {
            tree.expandRow(row);
        }

        p.add(new JScrollPane(tree),BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, p);
    }

    public boolean findText(String nodes) {
        String[] parts = nodes.split(":");
        TreePath path = null;
        for (String part : parts) {
            int row = (path==null ? 0 : tree.getRowForPath(path));
            path = tree.getNextMatch(part, row, Position.Bias.Forward);
            if (path==null) {
                return false;
            }
        }
        tree.scrollPathToVisible(path);
        tree.setSelectionPath(path);

        return path!=null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TreeNodeLocation();
            }
        });
    }
}