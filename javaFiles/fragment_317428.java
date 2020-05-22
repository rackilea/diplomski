//The first type in AsyncTask<> is for specifying the type of input given.
//Second parameter: Type of data to give to onProgressUpdate.
//Third parameter: Type of data to give to onPostExecute.
private class MyTask extends AsyncTask<String, String, String> {

    private String resp;
    ProgressDialog progressDialog;

    @Override
    protected String doInBackground(String... params) {
        publishProgress("Processing ..."); // Calls onProgressUpdate()
        //params is the input you've given that can be used for processing.

        getUserDataFromServer()
        getProductsDataFromServer()
        getBannersFromServer()

        //Result is the String to give onPostExecute when the task is done executing.
        String result = "Done Processing";
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        // Get the result from your task after it is done running.
        progressDialog.dismiss();
        //IMPORTANT: As you asked in your question, you can now execute whatever code you 
        //want since the task is done running.

    }

    @Override
    protected void onProgressUpdate(String... text) {
        //Progress has been updated. You can update the proggressDialog.       
    }
}