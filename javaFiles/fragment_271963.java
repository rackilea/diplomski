// BasicFileChooserUI
/**
 * Returns the default accept all file filter
 */
public FileFilter getAcceptAllFileFilter(JFileChooser fc) {
    return acceptAllFileFilter;
}

// buggy acceptAllFilter: doens't respect locale
protected class AcceptAllFileFilter extends FileFilter {

    public AcceptAllFileFilter() {
    }

    public boolean accept(File f) {
        return true;
    }

    public String getDescription() {
        return UIManager.getString("FileChooser.acceptAllFileFilterText");
    }
}