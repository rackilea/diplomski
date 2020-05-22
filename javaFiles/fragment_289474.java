public boolean checkExtensionCaseSensitive(File _file, String _extension) throws IOException{
    String canonicalPath = _file.getCanonicalPath();
    String extension = "";
    int i = canonicalPath.lastIndexOf('.');
    if (i > 0) {
        extension = canonicalPath.substring(i+1);
        if(extension.equals(_extension))
            return true;
    }
    return false;
}