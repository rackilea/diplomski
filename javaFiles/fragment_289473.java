public boolean exists(File dir, String filename){
    String[] files = dir.list();
    for(String file : files)
        if(file.equals(filename))
            return true;
    return false;
}