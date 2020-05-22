@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ....

    // AsyncTask start
    new FillText().execute();

    ..

}

private class FillText extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        String result = "";
        // get html document structure
        Document document = Jsoup.connect(BLOG_URL).get();
        // selector query
        //while (!document.)
        Elements nodeBlogStats = document.select(".ttElement");
        // check results
        if(nodeBlogStats.size() > 0) {
            // get value
            result = nodeBlogStats.get(0).text();
        }

        // return
        return result;
    }

    @Override
    protected void onPostExecute(String myText) {
        super.onPostExecute(myText);

        if(!myText.equals(""))
            ((TextView)findViewById(R.id.tv)).setText(myText);
    }
}