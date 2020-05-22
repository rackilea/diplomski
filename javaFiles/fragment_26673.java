/**
 * Returns the selected file from a JFileChooser, including the extension from
 * the file filter.
 */
public static File getSelectedFileWithExtension(JFileChooser c) {
    File file = c.getSelectedFile();
    if (c.getFileFilter() instanceof FileNameExtensionFilter) {
        String[] exts = ((FileNameExtensionFilter)c.getFileFilter()).getExtensions();
        String nameLower = file.getName().toLowerCase();
        for (String ext : exts) { // check if it already has a valid extension
            if (nameLower.endsWith('.' + ext.toLowerCase())) {
                return file; // if yes, return as-is
            }
        }
        // if not, append the first extension from the selected filter
        file = new File(file.toString() + '.' + exts[0]);
    }
    return file;
}