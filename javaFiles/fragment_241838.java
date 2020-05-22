private void exportDB(){
    File sd = Environment.getExternalStorageDirectory();
    File data = Environment.getDataDirectory();
    FileChannel source=null;
    FileChannel destination=null;
    String currentDBPath = "/data/"+ getPackageName() +"/databases/"+DatabaseHandler.DATABASE_NAME;
    String retreivedDBPAth = getDatabasePath(DatabaseHandler.DATABASE_NAME).getPath();
    String backupDBPath = "/storage/extSdCard/mydatabase";
    File currentDB = new File(data, currentDBPath);
    File backupDB = new File(sd, backupDBPath);
    File retrievedDB = new File(retreivedDBPAth);
    Log.d("PATHS", " CurrentDB=" +
            currentDBPath + "\n\t" + currentDB.getPath() +
            "\n\tExists=" + String.valueOf(currentDB.exists()) +
            "\nBackup=" + backupDBPath + "\n\t" + backupDB.getPath() +
            "\n\tExists=" + String.valueOf(backupDB.exists()) +
            "\nRetrieved DB=" + retreivedDBPAth + "\n\t" + retrievedDB.getPath() +
            "\n\tExists=" + String.valueOf(retrievedDB.exists())
    );
    try {
        source = new FileInputStream(currentDB).getChannel();
        destination = new FileOutputStream(backupDB).getChannel();
        //destination.transferFrom(source, 0, source.size());
        source.close();
        destination.close();
    } catch(IOException e) {
        e.printStackTrace();
        Toast.makeText(this, "Err:"+e, Toast.LENGTH_LONG).show();
    }
}