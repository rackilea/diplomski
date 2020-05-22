private class YourTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... s) {

            //Here you have to make the loading / parsing tasks
            //Don't call any UI actions here. For example a Toast.show() this will couse Exceptions
            // UI stuff you have to make in onPostExecute method

        }

        @Override
        protected void onPreExecute() {
            // This method will called during doInBackground is in process
            // Here you can for example show a ProgressDialog
        }

        @Override
        protected void onPostExecute(Long result) {
            // onPostExecute is called when doInBackground finished
            // Here you can for example fill your Listview with the content loaded in doInBackground method

        }

}