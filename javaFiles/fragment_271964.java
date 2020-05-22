protected class AcceptAllFileFilter extends FileFilter {

    private Locale locale;

    public AcceptAllFileFilter(Locale locale) {
        this.locale = locale;
    }

    @Override
    public boolean accept(File f) {
        return true;
    }

    @Override
    public String getDescription() {
        return UIManager.getString("FileChooser.acceptAllFileFilterText", locale);
    }
}