JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);

    chooser.setMultiSelectionEnabled(false);
    int returnVal = chooser.showSaveDialog(null);
    if(returnVal == JFileChooser.APPROVE_OPTION){
    File f = chooser.getSelectedFile();
    String a = f.getAbsolutePath();
    SaveToExcel exp = new SaveToExcel();
    exp.writePropertiesIntoExcel(a);
}