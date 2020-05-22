public static void main(String[] args) {
    // create a FileFilter 
    FileFilter ff = new FileFilter();
    // use finder method to get array of Files
    File[] files = ff.finder(yourFolder);
    // if files is empty
    if (files == null || files.length == 0) {
        // throw or print the error
    } else {
        // iterate over all found files:
        for (File f : files) {
            // f is pointing to excel file
        }
    }
}