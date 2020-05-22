class JsoupParseTask extends AsyncTask<String, Void, Document> {

    @Override
    protected Document doInBackground(String... urls) {

        Document doc = null;
        try {
            doc = Jsoup.connect("http://google.com/").get();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return doc;
    }

    @Override    
    protected void onPostExecute(Document doc) { 
        // execution of result here 

        String title = doc.title();
    }

}