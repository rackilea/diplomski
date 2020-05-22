public void approveSelection() {
    File f = getSelectedFile();
    // remove the CWD from the string - leaving the text from the edit box
    String prena = f.toString().replace(getCurrentDirectory().toString() + File.separator, "");
    String name = expandFileName(prena);
    if (prena.equals(name)) {
        if (!f.exists()) {
            return;
        }
        // This expanded to the same, and the file is there
        super.approveSelection();
        return;
    }
    // try to use the name
    f = new File(name);
    if (f.isFile()) { // file, ok
        setSelectedFile(f);
        super.approveSelection();
    } else if (f.isDirectory()) { // change to dir
        setCurrentDirectory(f);
        return;
    } else if (!f.exists()) { // try with cwd and name in field
        f = new File(getCurrentDirectory(), name);
        if (f.exists()) {
            setSelectedFile(f);
            super.approveSelection();
        }
    }
}