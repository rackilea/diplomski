private class DoHardWork extends AsyncTask<Void, String, Long> {
    protected Long doInBackground(Void... urls) {
         publishProgress("Requesting XML data");
         this.requestData();

         publishProgress("Returning results");
         this.returnResults();

         return null;
    }

    protected void onProgressUpdate(String... progress) {
        super.onProgressUpdate(progress);
        MainActivity.setLog(progress[0]);
    }


}