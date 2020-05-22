private class FileAsyncTask extends AsyncTask<ArrayList<String>, Void, Void> {         
    ArrayList<String> files;         
    ProgressDialog dialog;         
    @Override         
    protected void onPreExecute() {             
        dialog = ProgressDialog.show(ActivityName.this, "Your Title", "Loading...");         
    }         
    @Override         
    protected Void doInBackground(ArrayList<String>... params) {              
        files = params[0];             
        for (int i = 0; i < files.size(); i++) {                 
            copyFileToSDCard(files.get(i));                
        }             return null;         
    }         
    @Override         
    protected void onPostExecute(Void result) {             
        dialog.dismiss();         
    }      
}