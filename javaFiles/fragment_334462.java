for(int i = 0; i < filesDirs.size(); i++) {
    File file = (File)filesDirs.get(i);
    if (file.isHidden() && !readHiddenFiles) {
        return result;
    }
    if(handler == null || !handler.isExempt(file)) {
        result.add(file);
        if (file.isDirectory()) {
            List deeperList = getFilesInDirectoryRec(file, readHiddenFiles);
            result.addAll(deeperList);
        }
    }
}