public String splitPath(String path) {
    int index = path == null ? -1 : path.indexOf("/"); // null check
    if (index != -1) 
        return splitPath(path.substring(index + 1));
    return path;
    //or : 
    // int index = path == null ? -1 : path.indexOf("/"); // null check
    // return index == -1 ? path : splitPath(path.subString(index + 1));
}