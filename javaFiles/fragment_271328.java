import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class DriveTree extends JPanel {

    public DriveTree(File dir) {
        setLayout(new BorderLayout());
        JTree tree = new JTree(addNodes(null, dir));
        add(tree);
    }

    DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {
        String curPath = dir.getPath();
        DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(curPath);
        if (curTop != null) {
            curTop.add(curDir);
        }

        List<File> files = new ArrayList<File>(Arrays.asList(dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String name = pathname.getName().toLowerCase();
                return name.endsWith(".h") || (pathname.isDirectory() && !("System Volume Information".equalsIgnoreCase(name)));
            }
        })));

        Collections.sort(files);
//        File f;
//        Vector files = new Vector();
//        for (int i = 0; i < ol.size(); i++) {
//            String thisObject = (String) ol.elementAt(i);
//            String newPath;
//            if (curPath.equals(".")) {
//                newPath = thisObject;
//            } else {
//                newPath = curPath + File.separator + thisObject;
//            }
//            if ((f = new File(newPath)).isDirectory()) {
//                addNodes(curDir, f);
//            } else {
//                files.addElement(thisObject);
//            }
//        }
        for (File file : files) {
            if (file.isDirectory()) {
                addNodes(curDir, file);
            }
        }
        for (File file : files) {
            if (file.isFile()) {
                curDir.add(new DefaultMutableTreeNode(file));
            }
        }
        return curDir;
    }

    public static void main(String[] av) {

        JFrame frame = new JFrame("Drive View");
        Container cp = frame.getContentPane();
        if (av.length == 0) {
            cp.add(new DriveTree(new File(".")));
        } else {
            cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
            for (int i = 0; i < av.length; i++) {
                cp.add(new DriveTree(new File(av[i])));
            }
        }
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}