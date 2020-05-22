public class TestTree extends JFrame {

    JTree tree;
    DefaultTreeModel treeModel;

    public TestTree() {
        super("Tree Test Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected File[] getListFiles(String Path) {
        File file = new File(Path);
        return file.listFiles();
    }

    private void addChilds(DefaultMutableTreeNode rootNode, String path) {
        File[] files = this.getListFiles(path);
        for(File file:files) {
            if(file.isDirectory()) {
                DefaultMutableTreeNode subDirectory = new DefaultMutableTreeNode(file.getName());
                addChilds(subDirectory, file.getAbsolutePath());
                rootNode.add(subDirectory);
            } else {
                rootNode.add(new DefaultMutableTreeNode(file.getName()));
            }
        }
    }

    public void init() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Computerscience");

        addChilds(root, "C:\\Users\\neginn\\Google Drive\\NetBeansProjects\\computerscience");

        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

        getContentPane().add(tree, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        TestTree tt = new TestTree();
        tt.init();
        tt.setVisible(true);
    }
}