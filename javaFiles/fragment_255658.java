try {
    final URL url = new URL("http://urlhere.co.uk/files/testFile.txt");
    new AsyncTask<Void, Void, String>() {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                URLConnection con = url.openConnection();
                InputStream is = con.getInputStream();

                BufferedReader br;
                try {
                    br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    if ((line = br.readLine()) != null) {
                        return line;
                    }
                } finally {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String link) {
            mWebView.loadUrl("file:///" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + link);            
        }
    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
} catch (MalformedURLException e) {
    e.printStackTrace();
}