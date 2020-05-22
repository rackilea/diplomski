// AsyncTass for the Progress Dialog and to do Background Process
private class myAsyncTask extends AsyncTask<ArrayList<String>, Void, Void> {         
    ArrayList<String> files;         
    ProgressDialog dialog;         
    @Override         
    protected void onPreExecute() {             
        dialog = ProgressDialog.show(ListSample.this, "W1 SALES (beta)", "Loading...");         
    }         
    @Override         
    protected Void doInBackground(ArrayList<String>... params) {              
        files = params[0];             
        for (int i = 0; i < files.size(); i++) {                 
            copyFileFromAssetsToSDCard(files.get(i));                
        }             return null;         
    }         
    @Override         
    protected void onPostExecute(Void result) {             
        dialog.dismiss();         
    }      
} 



 // Function to copy file from Assets to the SDCard
public void copyFileFromAssetsToSDCard(String fileFromAssets){
    AssetManager is = this.getAssets();
    InputStream fis;
    try {

        fis = is.open(fileFromAssets);
        FileOutputStream fos;
        if (!APP_FILE_PATH.exists()) {
            APP_FILE_PATH.mkdirs();
        }
        fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory()+"/SampleProjectApp", fileFromAssets));
        byte[] b = new byte[8];
        int i;
        while ((i = fis.read(b)) != -1) {
            fos.write(b, 0, i);
        }
        fos.flush();
        fos.close();
        fis.close();
    } 
    catch (IOException e1) {
        e1.printStackTrace();
    }
}