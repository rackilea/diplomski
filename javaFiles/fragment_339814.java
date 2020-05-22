private class loadingTask extends AsyncTask<String, Void, List<Manga>> {
    @Override
    protected String doInBackground(String... urls) {
        try {
            return loadXmlFromNetwork(urls[0]);
        } catch (IOException e) {
            return null;
        } catch (XmlPullParserException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Manga> result) {  
        setContentView(R.layout.activity_main);
        // Displays the HTML string in the UI via a WebView
        listview1.setAdapter(new EfficientAdapter(MainActivity.this, result));
        ShowProgress.dismiss();
    }
}

public List<Manga> loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {

....