public String splitPath(String path){
    if (path == "") { 
        return null;
    }

    if(path.indexOf("/") != -1){
        String subPath = path.substring(path.indexOf("/") + 1);
        splitPath(subPath);
    } 
    return path;
}