private classImageUpload extends AsyncTask<String, Void, String> {

@Override
protected String doInBackground(String... params) {
    //your upload code here
    return "Executed";
}

@Override
protected void onPostExecute(String result) {}

@Override
protected void onPreExecute() {}

@Override
protected void onProgressUpdate(Void... values) {}