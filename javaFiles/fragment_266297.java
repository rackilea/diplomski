import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Test {

    private final JFrame frame;
    private final JTree tree;
    private final DefaultMutableTreeNode root;
    private final DefaultTreeModel model;
    private final Map<String, DefaultMutableTreeNode> treeMap;
    private final boolean reload;
    private int index;
    private final String[] folders = {
        "Data", "trial 0",
        "Data/trial 0", "trial 1",
        "Data/trial 0/trial 1", "trial 2",
        "Data", "trial 1",
        "Data/trial 1", "trial 2",
        "Data", "trial 2"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Test(true);
            new Test(false);
        });
    }

    public Test(boolean reload) {
        this.reload = reload;
        frame = new JFrame(String.valueOf(reload));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        treeMap = new HashMap<>();
        root = new DefaultMutableTreeNode("Data");
        model = new DefaultTreeModel(root);
        tree = new JTree(model);
        treeMap.put("Data", root);
        frame.add(tree, BorderLayout.WEST);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Timer t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < folders.length) {
                    addNewFolder(folders[index++], folders[index++]);
                    for (int i = 0; i < tree.getRowCount(); i++) {
                        tree.expandRow(i);
                    }
                    frame.pack();
                }
            }
        });
        t.start();
    }

    private void addNewFolder(String path, String name) {
        DefaultMutableTreeNode currentNode = treeMap.get(path);
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(name);
        currentNode.add(childNode);
        treeMap.put(path + "/" + name, childNode);
        if (reload) {
            model.reload();
        } else {
            model.nodeStructureChanged(currentNode);
        }
    }
}