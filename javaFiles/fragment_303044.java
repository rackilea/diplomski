private static void copyDataBase(String dbname) throws IOException {
    InputStream myInput = mCtx.getAssets().open(dbname);
    String outFileName = MAIN_DB_PATH + dbname;
    OutputStream myOutput = new FileOutputStream(outFileName);
    byte[] buffer = new byte[1024];
    int length;
    while ((length = myInput.read(buffer)) > 0) {
        myOutput.write(buffer, 0, length);
    }
    myOutput.flush();
    myOutput.close();
    myInput.close();
}