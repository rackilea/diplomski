private File findFile(File f, String name){
    if(f.getName().equals(name))
        return f;
    File file = null;
    if (f.isDirectory()) {
        for(File c : ((Directory) f).getChildren()){
            file = findFile(c, name);
            if(file != null)
                break; 
        }
    }
    return file;
}