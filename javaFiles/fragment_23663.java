File xmlFile = new File(chooser.getSelectedFile().toString()
        + ".xml");
if (xmlFile.exists()) {
    int response = JOptionPane.showConfirmDialog(null, //
            "Do you want to replace the existing file?", //
            "Confirm", JOptionPane.YES_NO_OPTION, //
            JOptionPane.QUESTION_MESSAGE);
    if (response != JOptionPane.YES_OPTION) {
        return;
    } 
}