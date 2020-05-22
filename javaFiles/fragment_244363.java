import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class SearchTree extends JFrame {

    private final DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    private final DefaultTreeModel model = new DefaultTreeModel(root);
    private final JTree tree = new JTree(model);
    private final JLabel searchLabel = new JLabel("Enter Node to be searched");
    private final JTextField searchText;
    private final ArrayList<DefaultMutableTreeNode> initNodes = new ArrayList<>();

    public SearchTree() {

        DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("Sample 1");
        n1.add(new DefaultMutableTreeNode("2nd level: Child l"));
        n1.add(new DefaultMutableTreeNode("Search Me"));
        n1.add(new DefaultMutableTreeNode("Bob"));

        DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("Find me");
        n2.add(new DefaultMutableTreeNode("2nd level: Child 2"));
        n2.add(new DefaultMutableTreeNode("Peter"));
        n2.add(new DefaultMutableTreeNode("Lily"));

        DefaultMutableTreeNode n3 = new DefaultMutableTreeNode("Explore me");
        n3.add(new DefaultMutableTreeNode("Search Me Please"));
        n3.add(new DefaultMutableTreeNode("Rome"));
        n3.add(new DefaultMutableTreeNode("Italy"));

        initNodes.add(n1);
        initNodes.add(n2);
        initNodes.add(n3);

        root.add(n1);
        root.add(n2);
        root.add(n3);

        tree.setEditable(true);
        tree.setSelectionRow(0);

        JScrollPane scrollPane = new JScrollPane(tree);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createEtchedBorder());

        searchText = new JTextField(20);
        searchText.getDocument().addDocumentListener(new SearchListener());
        searchPanel.add(searchText);

        searchPanel.add(searchLabel);

        getContentPane().add(searchPanel, BorderLayout.SOUTH);
        setSize(700, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void removeNode(DefaultMutableTreeNode selNode) {
        if (selNode == null) {
            return;
        }
        MutableTreeNode parent = (MutableTreeNode) (selNode.getParent());
        if (parent == null) {
            return;
        }
        MutableTreeNode toBeSelNode = getSibling(selNode);
        if (toBeSelNode == null) {
            toBeSelNode = parent;
        }
        TreeNode[] nodes = model.getPathToRoot(toBeSelNode);
        TreePath path = new TreePath(nodes);
        tree.scrollPathToVisible(path);
        tree.setSelectionPath(path);
        model.removeNodeFromParent(selNode);
        initNodes.remove(selNode);
    }

    private MutableTreeNode getSibling(DefaultMutableTreeNode selNode) {
        MutableTreeNode sibling = (MutableTreeNode) selNode
                .getPreviousSibling();
        if (sibling == null) {
            sibling = (MutableTreeNode) selNode.getNextSibling();
        }
        return sibling;
    }

    private class SearchListener implements DocumentListener {

        boolean expandIt = false;

        @Override
        public void insertUpdate(DocumentEvent e) {
            documentListener();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            documentListener();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            documentListener();
        }

        private void documentListener() {
            ArrayList<DefaultMutableTreeNode> list = searchNode(searchText.getText());
            root.removeAllChildren();
            for (DefaultMutableTreeNode mtn : list) {
                root.add(mtn);
            }

            model.reload(root);
            if (expandIt) {
                for (int i = 0; i < tree.getRowCount(); i++) {
                    tree.expandRow(i);
                }
            }

        }

        public ArrayList<DefaultMutableTreeNode> searchNode(String nodeStr) {
            if (nodeStr == null || nodeStr.isEmpty()) {
                expandIt = false;
                return initNodes;
            }
            expandIt = true;
            ArrayList<DefaultMutableTreeNode> list = new ArrayList<>();
            for (DefaultMutableTreeNode mtn : initNodes) {
                if (checkText(mtn, nodeStr)) {
                    list.add(mtn);
                    continue;
                }
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) mtn.clone();
                for (int i = 0; i < mtn.getChildCount(); i++) {
                    DefaultMutableTreeNode child = (DefaultMutableTreeNode) mtn.getChildAt(i);
                    if (checkText(child, nodeStr)) {
                        parent.add((DefaultMutableTreeNode) child.clone());
                    }
                }
                if (parent.getChildCount() > 0) {
                    list.add(parent);
                }
            }
            return list;
        }

        public boolean checkText(DefaultMutableTreeNode node, String text) {
            return node.getUserObject().toString().toLowerCase().startsWith(text.toLowerCase());
        }
    }

    public static void main(String[] arg) {
        SearchTree st = new SearchTree();
    }
}