import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Temp extends JPanel{
    JTree tree = new JTree();

    public Temp(){
        JScrollPane jsp = new JScrollPane(tree);

        // Creates the library pane that contains the tabs with the palettes
        JTabbedPane libraryPane = new JTabbedPane();

        libraryPane.add("new Explorere", jsp);

        // Creates the inner split pane that contains the library with the
        // palettes and the graph outline on the left side of the window
        JSplitPane inner = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                libraryPane, new JPanel());
        inner.setDividerLocation(320);
        inner.setResizeWeight(1);
        inner.setDividerSize(6);
        inner.setBorder(null);

        // Creates the outer split pane that contains the inner split pane and
        // the graph component on the right side of the window
        JSplitPane outer = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, inner,
                new JPanel());
        outer.setOneTouchExpandable(true);
        outer.setDividerLocation(200);
        outer.setDividerSize(6);
        outer.setBorder(null);

        // Puts everything together
        setLayout(new BorderLayout());
        add(outer, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        final Temp temp = new Temp();
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(temp);
                frame.pack();
                frame.setVisible(true);
            }});

        Thread updater = new Thread(temp.new CustomThread());
        updater.start();
    }

    public class CustomThread implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 1000; i++){
                updateTree("New Item "+ i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public void updateTree(final String nodeToAdd){
            SwingUtilities.invokeLater(new Runnable(){

                @Override
                public void run() {
                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
                    DefaultMutableTreeNode child = new DefaultMutableTreeNode(nodeToAdd);
                    model.insertNodeInto(child, root,root.getChildCount());
                    tree.scrollPathToVisible(new TreePath(child.getPath()));
                }});

        }

    }
}