private void loadFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) { 
    int returnVal = fileChoser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChoser.getSelectedFile();
        logger.debug("Opening SD-File '{}'.", file.getAbsoluteFile());
        FileLoader loader = new FileLoader(this, file);
        loader.execute();
    } 
}