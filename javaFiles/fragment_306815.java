private class DownloadTask extends AsyncTask<String, Integer, String> {

    Document doc = null;

    protected String doInBackground(String... params) {

        try {
            doc = Jsoup.connect(params[0]).get();
            return doc.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        logAll("async",doc.toString());
    }

    void logAll(String TAG, String longString) {

        int splitSize = 300;

        if (longString.length() > splitSize) {
            int index = 0;
            while (index < longString.length()-splitSize) {
                Log.e(TAG, longString.substring(index, index + splitSize));
                index += splitSize;
            }
            Log.e(TAG, longString.substring(index, longString.length()));
        } else {
            Log.e(TAG, longString.toString());
        }
    }
}