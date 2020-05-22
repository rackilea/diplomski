private boolean isPathDirectory(String myPath) {
    File test = new File(myPath);

    // check if the file/directory is already there
    if (!test.exists()) {
        // see if the file portion it doesn't have an extension
        return test.getName().lastIndexOf('.') == -1;
    } else {
        // see if the path that's already in place is a file or directory
        return test.isDirectory();
    }
}