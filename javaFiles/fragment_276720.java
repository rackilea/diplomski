public void openAndManipulateFile(final File root) {

    // get the list of files/folders
    final File[] files = root.listFiles();
    int counter = 0;

    for (File file : files) {

        // if its a directory, read its contents
        if (file.isDirectory()) {
            // recursive method call
            openAndManipulateFile(file);
        } else {
            if (++counter == 3) {
                // open and manipulate the 3rd file
            }
        }
    }
}