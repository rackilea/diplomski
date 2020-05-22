public File find(Checker<File> checker) {
    for(File f : fileList) {
        if(checker.hasProperty(f))
            return f;
    }
    return null;
}