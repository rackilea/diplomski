public File getFileAddress() {
    JFileChooser chooser = new JFileChooser();
    //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int returnVal = chooser.showSaveDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       return chooser.getSelectedFile();
    }
    return null;
}