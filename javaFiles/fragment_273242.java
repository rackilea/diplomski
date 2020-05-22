import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;

class FileMutableTreeNode extends DefaultMutableTreeNode {

    private File fileNode = null;

    public FileMutableTreeNode(File fileNode) {
        this.fileNode = fileNode;
    }

    public File getFileNode() {
        return fileNode;
    }

    @Override
    public String toString() {
        //For root, returning the name as '/'
        if (fileNode.getAbsolutePath().equals("/")) {
            return "/";
        } else {
            return fileNode.getName();
        }
    }
}