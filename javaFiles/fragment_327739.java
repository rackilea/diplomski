int returnVal = fc.showOpenDialog(FileChooserDemo.this);

if (returnVal == JFileChooser.APPROVE_OPTION) {
    File file = fc.getSelectedFile();
    //This is where a real application would open the file.
} else {
    // Do nothing or log it
}