public class Test {
    private JFrame frame;
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultTreeModel model;
    private Map<String, DefaultMutableTreeNode> treeMap;

    public static void main(String[] args)
    {
        Test t = new Test();
        t.add_new_folder("Data","trial 0");
        t.add_new_folder("Data/trial 0","trial 1");
        t.frame.revalidate();
        t.frame.repaint();
    }

    public Test()
    {
        frame = new JFrame();
        tree = new JTree();
        root = new DefaultMutableTreeNode("Data");
        model = new DefaultTreeModel(root);
        tree.setModel(model);
        frame.getContentPane().add(tree, BorderLayout.WEST);
        frame.setVisible(true);
        frame.setSize(500, 500);
        treeMap = new HashMap<>();
        treeMap.put("Data", root);
    }

     public void add_new_folder(String path,String name){
        DefaultMutableTreeNode currentNode = treeMap.get(path);
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(name);
        currentNode.add(childNode);
        treeMap.put(path+"/"+name, childNode);
        model.reload();
    }
}