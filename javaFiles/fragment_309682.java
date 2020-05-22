private class FetchWebsiteData extends AsyncTask<Void, Void, Void> {
    String websiteTitle, websiteDescription;

    @Override
    protected void onPreExecute() {
        //progress dialog
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            // Connect to website
            Document document = Jsoup.connect(URL).get();
            // Get the html document title
            websiteTitle = document.title();
            Elements description = document.select("meta[name=description]");
            // Locate the content attribute
            websiteDescription = description.attr("content");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // Set title into TextView
        TextView txttitle = (TextView) findViewById(R.id.txtData);
        txttitle.setText(websiteTitle + "\n" + websiteDescription);
        mProgressDialog.dismiss();
    }
}