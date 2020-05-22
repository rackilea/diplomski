private String getWhereToSave(){
    int retVal = fc.showSaveDialog(..);
    if(retVal == JFileChooser.APPROVE_OPTION){
        File file = fc.getSelectedFile();
        return file.getAbsolutePath();
    }
    return null;
}