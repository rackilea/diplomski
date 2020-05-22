JFileChooser chooser = new JFileChooser();

File file = null;
int returnVal = chooser.showOpenDialog(null);
if(returnVal == JFileChooser.APPROVE_OPTION) {
    file = chooser.getSelectedFile();
}

try {
    Scanner scanner = new Scanner(file);
    // read file
} catch (Exception ex) {
    ex.printStackTrace();
}