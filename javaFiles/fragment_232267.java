import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

class ShowPrefixedDrawings {

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.setMultiSelectionEnabled(true);
                chooser.setAcceptAllFileFilterUsed(false);
                String prefix = JOptionPane.showInputDialog(
                    null, "Prefix", "D");
                chooser.setFileFilter(
                    new PrefixDrawingFileFilter(prefix));
                int result = chooser.showOpenDialog(null);
                if (result==JFileChooser.APPROVE_OPTION) {
                    File[] files = chooser.getSelectedFiles();
                    for (File file : files) {
                        System.out.println(file.getName());
                    }
                }
                System.exit(0);
            }
        });
    }
}

class PrefixDrawingFileFilter extends FileFilter {

    String prefix;
    String[] suffixes = {"dwg", "dxf", "DWG", "DXF"};

    PrefixDrawingFileFilter(String prefix) {
        this.prefix = prefix;
    }

    public boolean accept(File f) {
        if (f.isDirectory()) return true;

        String name = f.getName();
        if ( name.startsWith(prefix) ) {
            for (String type : suffixes) {
                if (name.endsWith(type)) return true;
            }
        }

        return false;
    }

    public String getDescription() {
        return "eDrawings Viewer files starting with " + prefix;
    }
}