public boolean copyDBFile(){
File dbFile =new File(Environment.getDataDirectory() + DB_PATH);
File exportDir = new File(Environment.getExternalStorageDirectory()
  + "/BACKUP_DIR");
if (!exportDir.exists()) {
    exportDir.mkdirs();
}

File file = new File(exportDir, dbFile.getName());
try {
    file.createNewFile();           
    copyFile(dbFile, file);
    return true;
} catch (IOException e) {  
    Log.e("Sarelo", "Error creating file", e);
    return false;
}