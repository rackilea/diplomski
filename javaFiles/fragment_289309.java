//YOU NAME THIS myInput:
    InputStream myInput = firstDBContext.getAssets().open(DB_NAME);
    String outFileName = DB_PATH + DB_NAME;
    OutputStream bnOutput = new FileOutputStream(outFileName);
    byte[] buffer = new byte[1024];
    int length; 
    //YOU READ FROM bnInput:
    while ((length = bnInput.read(buffer)) > 0){
        bnOutput.write(buffer, 0, length);
    }