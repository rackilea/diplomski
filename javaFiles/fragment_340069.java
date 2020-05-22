JFileChooser input = new JFileChooser();
FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "BMP Images", "bmp");
input.setFileFilter(filter);
if (input.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
    File inputFile = input.getSelectedFile();
    // Process file
}