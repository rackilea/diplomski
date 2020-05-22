public String getExternalPath(){
    String removableStoragePath = "";
    File fileList[] = new File("/storage/").listFiles();
    for (File file : fileList)
    { if(!file.getAbsolutePath().equalsIgnoreCase(Environment.getExternalStorageDirectory().getAbsolutePath()) && file.isDirectory() && file.canRead())
        removableStoragePath = file.getAbsolutePath(); }
    return removableStoragePath;
}