JFileChooser fc = new JFileChooser();
fc.setDialogTitle("Open stuff");
fc.addChoosableFileFilter(new FileFilter() {

    @Override
    public boolean accept(File f) {
        return f.getName().toLowerCase().endsWith(".xml") || f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "XML Document (*.xml)";
    }
});

switch (fc.showOpenDialog(null)) {
    case JFileChooser.APPROVE_OPTION:
        File file = fc.getSelectedFile();
        lireFichier(file.getPath()); 
        break;
}