public FileReader()  {
    //create fileChooser
    JFileChooser chooser = new JFileChooser();
    //open fileChooser
    int returnValue = chooser.showOpenDialog(new JFrame());
    try {
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}