protected int chooseOpenFile() {
    JFileChooser fileChooser = new JFileChooser(model.getSavedInputFile());

    int status = fileChooser.showOpenDialog(frame.getFrame());

    if (status == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        model.setSavedInputFile(selectedFile);
    }

    return status;
}