//Reference : http://www.javaprogrammingforums.com/java-swing-tutorials/7944-how-use-jtree-create-file-system-viewer-tree.html
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class FileSysBrowser extends JFrame {

    public JTree fileTree;
    private FileSystemModel fileSystemModel;

    public FileSysBrowser(String directory) {
//        System.out.println("REPO : " + Arrays.toString(REPO_PATH));
        setTitle("FileSysBrowser");
        fileSystemModel = new FileSystemModel(new FileMutableTreeNode(new File(directory)));
        fileTree = new JTree(fileSystemModel);
        fileTree.setEditable(false);
        JPanel pnlMain = new JPanel(new BorderLayout(5, 5));
        pnlMain.add(new JScrollPane(fileTree), BorderLayout.CENTER);
        final JButton btn = new JButton("click");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread() {
                    @Override
                    public void run() {
                        btn.setEnabled(false);
                        expandNodePath("/repo/dinesh/trunk/Design/");
                        btn.setEnabled(true);
                    }
                }.start();

            }
        });
        pnlMain.add(btn, BorderLayout.PAGE_END);
        getContentPane().add(pnlMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }
//Reference : https://stackoverflow.com/questions/8210630/how-to-search-a-particular-node-in-jtree-and-make-that-node-expanded 
//Thanks to 'trashgod' for the answer    
    private FileMutableTreeNode findNode(FileMutableTreeNode root, String s) {
        @SuppressWarnings("unchecked")
        Enumeration<FileMutableTreeNode> e = root.depthFirstEnumeration();
        while (e.hasMoreElements()) {
            FileMutableTreeNode node = e.nextElement();
            if (node.toString().equals(s)) {
//                return new TreePath(node.getPath());
                return node;
            }
        }
        return null;
    }

    private void expandNodePath(String filePath) {
        if(filePath.startsWith("/")) {
            filePath = filePath.replaceFirst("/", "");
        }
        String[] files = filePath.split("/");
        //Initializing the parent node as 'root'
        FileMutableTreeNode parentNode = fileSystemModel.getRoot();
        for (String file : files) {
            FileMutableTreeNode childNode = findNode(parentNode, file);
            fileTree.expandPath(new TreePath(childNode.getPath()));
            // Then setting the current 'child' node as parent node 
            // for the next iteration
            parentNode = childNode;
        }

//  The below code is what the expansion of above for loop code. 
//  For ease of understanding, I have kept it for others. 
//        FileMutableTreeNode repoNode = findNode(fileSystemModel.getRoot(), "repo");
//        fileTree.expandPath(new TreePath(repoNode.getPath()));
//        FileMutableTreeNode dineshNode = findNode(repoNode, "dinesh");
//        fileTree.expandPath(new TreePath(dineshNode.getPath()));

    }

    public static void main(String args[]) {
//        System.out.println(new File("/").getName());

        FileSysBrowser fileSysBrowser = new FileSysBrowser("/");

        JTree jt = fileSysBrowser.fileTree;

        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath tp = e.getNewLeadSelectionPath();
                if (tp != null) {
                    System.out.println(tp);
//                    System.out.println(tp.getLastPathComponent());
                }
            }
        });
    }
}

class FileSystemModel implements TreeModel {

//    private File root;
    private FileMutableTreeNode root;

    private final Vector listeners = new Vector();

    public FileSystemModel(FileMutableTreeNode rootDirectory) {
        root = rootDirectory;
    }

    @Override
    public FileMutableTreeNode getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {

        FileMutableTreeNode parentNode = (FileMutableTreeNode) parent;
        File directory = parentNode.getFileNode();
        String[] children = directory.list();
        Arrays.sort(children);
        String currentChild = children[index];
        FileMutableTreeNode childNode = new FileMutableTreeNode(new File(directory, currentChild));
        if (parentNode.toString().equals("/")) {
            root.add(childNode);
        } else {
            parentNode.add(childNode);
        }
        return childNode;
    }

    @Override
    public int getChildCount(Object parent) {
        FileMutableTreeNode fileNode = (FileMutableTreeNode) parent;
        File file = fileNode.getFileNode();
        if (file.isDirectory()) {
            String[] fileList = file.list();
            if (fileList != null) {
                return file.list().length;
            }
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        FileMutableTreeNode fileNode = (FileMutableTreeNode) node;
        File file = fileNode.getFileNode();
        return file.isFile();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        FileMutableTreeNode parentNode = (FileMutableTreeNode) parent;
        File directory = parentNode.getFileNode();
        FileMutableTreeNode childNode = (FileMutableTreeNode) child;
        File file = childNode.getFileNode();
        String[] children = directory.list();
        for (int i = 0; i < children.length; i++) {
            if (file.getName().equals(children[i])) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public void valueForPathChanged(TreePath path, Object value) {
        System.out.println("valueForPathChanged -> path : " + path + ", value : " + value);
    }

    @Override
    public void addTreeModelListener(TreeModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener listener) {
        listeners.remove(listener);
    }

}