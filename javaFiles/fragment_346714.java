protected void installStrings(JFileChooser fc) {

        Locale l = fc.getLocale();
        newFolderErrorText = UIManager.getString("FileChooser.newFolderErrorText",l);
        newFolderErrorSeparator = UIManager.getString("FileChooser.newFolderErrorSeparator",l);

        newFolderParentDoesntExistTitleText = UIManager.getString("FileChooser.newFolderParentDoesntExistTitleText", l);
        newFolderParentDoesntExistText = UIManager.getString("FileChooser.newFolderParentDoesntExistText", l);
// ...
}