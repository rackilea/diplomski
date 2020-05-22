long getFileSize(File aFile) {

    //Function passed a single file, return the file's length.
    if(!aFile.isDirectory())
        return aFile.length();

    //Function passed a directory.
    // Sum and return the size of the directory's contents, including subfolders.
    long netSize = 0;
    File[] files = aFile.listFiles();
    for (File f : files) {
        if (f.isDirectory())
            netSize += getFileSize(f);
        else
            netSize += f.length();
    }
    return netSize;
}