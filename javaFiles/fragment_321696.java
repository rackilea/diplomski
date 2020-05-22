private void initSecurity() {
    final String secretFile = "secure_file";
    boolean keyExists = false;
    //check if secret key exist in secure file
    try {
        FileInputStream inputStream = openFileInput(secretFile);
        mSecretKey = new byte[16];
        int result = inputStream.read(mSecretKey);
        if(result >0) {
            keyExists = true;
        }
        inputStream.close();
    }
    catch (FileNotFoundException e) {}
    catch (IOException e){}
    if(!keyExists) {
        // generate a key
        mSecretKey = AppSecurity.generateKey();
        if(mSecretKey != null) {
            // write in a secure file inside the app
            try {
                // MODE_PRIVATE will create the file (or replace a file of the same name)
                // and make it private to the application.
                FileOutputStream outputStream = openFileOutput(secretFile,Context.MODE_PRIVATE);
                outputStream.write(mSecretKey);
                outputStream.close();
            }
            catch (FileNotFoundException e){}
            catch (IOException e) {}
        }
    }
}