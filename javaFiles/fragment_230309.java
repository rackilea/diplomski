import java.io.*;
import javax.swing.*;


class fctest {

    public class SketchFileView extends javax.swing.filechooser.FileView
    {
        @Override
        public Boolean isTraversable(File f) {
            if (f.getName().startsWith("images")) {
                return false;
            }
            if (f.isDirectory()) {
                return true;
            }
            return false; // added this
        }
    }

    public class SketchFolderFilter extends javax.swing.filechooser.FileFilter {
        public boolean accept(File f) {
            if (f.getName().startsWith("images")) {
                return true;
            }
            if (f.isDirectory()) {
                return true;
            }
            return false;
        }

        public String getDescription() {
            return "Sketch Folders";
        }
    }

    public void saveAs() {
        JFileChooser fc = new JFileChooser()
        {
            public void approveSelection()
            {
                if (getSelectedFile().getName().startsWith("images"))
                    super.approveSelection();
            }
        };

        javax.swing.filechooser.FileFilter filter = new SketchFolderFilter();
        fc.setFileFilter(filter);

        javax.swing.filechooser.FileView view = new SketchFileView();
        fc.setFileView(view);

//      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setCurrentDirectory(new File("."));
        fc.setSelectedFile( new File("blog") );

        int rv = fc.showSaveDialog(null);

        System.err.println("Option: " + rv);
        if (rv == JFileChooser.APPROVE_OPTION) {
            File newFile = fc.getSelectedFile();
            System.err.println("Save As: " + newFile.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        fctest main = new fctest();
        main.saveAs();
    }
}