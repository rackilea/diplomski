private void ls(File f) { 
    File[] list = f.listFiles();
    for (File file : list) {
        if (file.isDirectory()) ls(file);
        else handle(file);
    }
}