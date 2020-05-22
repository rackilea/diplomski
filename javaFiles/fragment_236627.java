import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class DynamicTreeDemo extends JPanel implements ActionListener {

    protected static final SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss");

    private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";

    private DefaultMutableTreeNode rootNode;
    private final DefaultTreeModel treeModel;

    private JTree left;
    private JTree right;

    public DynamicTreeDemo() {
        super(new BorderLayout());

        rootNode = new DefaultMutableTreeNode("Root Node");
        treeModel = new DefaultTreeModel(rootNode);

        left = new JTree(treeModel);
        left.setCellRenderer(new LeftTreeCellRenderer());
        right = new JTree(treeModel);
        right.setCellRenderer(new RightTreeCellRenderer());

        MyExpansionListener expansionListener = new MyExpansionListener(left, right);

        left.addTreeExpansionListener(expansionListener);
        right.addTreeExpansionListener(expansionListener);

        right.setSelectionModel(left.getSelectionModel());

        populateModel();

        JButton addButton = new JButton("Add");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);

        JButton removeButton = new JButton("Remove");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);

        JButton clearButton = new JButton("Clear");
        clearButton.setActionCommand(CLEAR_COMMAND);
        clearButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JScrollPane(left));
        panel.add(new JScrollPane(right));
        add(panel, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(0, 3));
        buttons.add(addButton);
        buttons.add(removeButton);
        buttons.add(clearButton);
        add(buttons, BorderLayout.SOUTH);
    }

    protected TreeData createNodeData() {
        return new TreeData("New Node " + newNodeSuffix++, SDF.format(new Date()));
    }

    public void populateModel() {
        String p1Name = "Parent 1";
        String p2Name = "Parent 2";

        DefaultMutableTreeNode p1, p2;

        p1 = addObject(null, p1Name);
        p2 = addObject(null, p2Name);

        addObject(p1, createNodeData());
        addObject(p1, createNodeData());

        addObject(p2, createNodeData());
        addObject(p2, createNodeData());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (ADD_COMMAND.equals(command)) {
            // Add button clicked
            addObject(createNodeData());
        } else if (REMOVE_COMMAND.equals(command)) {
            // Remove button clicked
            removeCurrentNode();
        } else if (CLEAR_COMMAND.equals(command)) {
            // Clear button clicked.
            clear();
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("DynamicTreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        DynamicTreeDemo newContentPane = new DynamicTreeDemo();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Remove all nodes except the root node.
     */
    public void clear() {
        rootNode.removeAllChildren();
        treeModel.reload();
    }

    /**
     * Add child to the currently selected node.
     */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = left.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child) {
        return addObject(parent, child, false);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child, boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

        // Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            left.scrollPathToVisible(new TreePath(childNode.getPath()));
            right.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    /**
     * Remove the currently selected node.
     */
    public void removeCurrentNode() {
        TreePath currentSelection = left.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
                    .getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        }

    }

    public class TreeData {

        private String left;
        private String right;

        public TreeData(String left, String right) {
            this.left = left;
            this.right = right;
        }

        public String getLeft() {
            return left;
        }

        public String getRight() {
            return right;
        }

    }

    public class LeftTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                Object userData = node.getUserObject();
                if (userData instanceof TreeData) {
                    value = ((TreeData) userData).getLeft();
                }
            }
            return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        }

    }

    public class RightTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                Object userData = node.getUserObject();
                if (userData instanceof TreeData) {
                    value = ((TreeData) userData).getRight();
                }
            }
            return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        }

    }

    public class MyExpansionListener implements TreeExpansionListener {

        private JTree left;
        private JTree right;

        public MyExpansionListener(JTree left, JTree right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void treeExpanded(TreeExpansionEvent event) {
            TreePath path = event.getPath();
            if (event.getSource() == left) {
                right.expandPath(path);
            } else {
                left.expandPath(path);
            }
        }

        @Override
        public void treeCollapsed(TreeExpansionEvent event) {
            TreePath path = event.getPath();
            if (event.getSource() == left) {
                right.collapsePath(path);
            } else {
                left.collapsePath(path);
            }
        }

    }
}