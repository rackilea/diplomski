JFileChooser dialog = new JFileChooser();
dialog.setMultiSelectionEnabled(true);
dialog.setFileFilter(new FileFilter() {

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean accept(File arg0) {
        return arg0.getAbsolutePath().endsWith("png")
                || arg0.getAbsolutePath().endsWith("jpg");
    }

});
dialog.showOpenDialog(rootPane);//open it last
File[] file = dialog.getSelectedFiles();