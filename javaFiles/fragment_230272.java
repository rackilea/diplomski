private static class MyTask extends AsyncTask<Void, Void, Void> {

           protected void onPreExecute() {
               // Show dialog here - note: showDialog is depricated.
           }

            protected Void doInBackground(Void... unused) {
                    // do the stuff that's in your thread here.
                    return null;
            }

            protected void onPostExecute(Void unused) {
                    // Dismiss dialog here - note: dismissDialog is depricated.
            }
}