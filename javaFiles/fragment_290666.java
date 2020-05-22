protected String doInBackground(String... params) {

        // updating UI from Background Thread
        runOnUiThread(new Runnable() {
            public void run() {
                // Check for success tag
                int success;
                try {
                    // Building Parameters
                    List<NameValuePair> params = new ArrayList<NameValuePair>();