private boolean loadFileList(String directory, String...extensions){
    for (String extension : extensions){
        if (filename.contains(extension))
            return true;
    }
    return false;
}