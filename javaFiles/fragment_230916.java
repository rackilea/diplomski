fc.setFileFilter(new FileFilter() {
    public boolean accept(File f) {
        if( checkForFileTypeOne() ||  checkForFileTypeTwo()) {
             return true;
        }
        return false;
    }

    public String getDescription() {
        return "Usefull files (*.abc, *.def)";
    }
});