JFileChooser fileChooser = new JFileChooser(new File(filename));
fileChooser.addChoosableFileFilter(new MyFilter());

// Open file dialog.
fileChooser.showOpenDialog(frame);
openFile(fileChooser.getSelectedFile());

class MyFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File file) {
        // load the image
        // check if it satisfies the criteria
        // return boolean result
    }
}