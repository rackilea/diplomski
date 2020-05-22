protected Void doInBackground(Void... unused) {
        LoadData();

        return (null);
    }

   protected void onPostExecute(Void unused) {
        // On completing background task
        // closing progress dialog etc,.

        list.setOnScrollListener(new EndlessScrollListener());

    }