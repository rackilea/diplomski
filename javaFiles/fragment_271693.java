final JFileChooser fc = new JFileChooser();
// Open the dialog using null as parent component if you are outside a
// Java Swing application otherwise provide the parent comment instead
int returnVal = fc.showOpenDialog(null);
if (returnVal == JFileChooser.APPROVE_OPTION) {
    // Retrieve the selected file
    File file = fc.getSelectedFile();
    try (FileInputStream fis = new FileInputStream(file)) {
        // Do something here
    }
}