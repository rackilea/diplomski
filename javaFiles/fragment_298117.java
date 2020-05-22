private void makeDirs() {
    //Check if the folder exists
    File importDir = new File (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/ENEL/IMPORTADOS/");
    if (!importDir.exists()) {
        importDir.mkdirs();
    }
}