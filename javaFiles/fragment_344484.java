JFileChooser fileChooser = new JFileChooser();
if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
    File file = fileChooser.getSelectedFile();
    // ...
} else {
    // User pressed cancel.
}