public class doit extends AsyncTask<Void,Void,String> {

@Override
protected String doInBackground(Void... params) {
    String words = "";
    try {

        Document doc = Jsoup.connect("http://www.blablabla.com/").get();
        Element newsHeadlines = doc.body().getElementById("div#content");
        System.out.println(newsHeadlines);
        words = doc.text();

    }catch (Exception e){e.printStackTrace();}

    return words;
}

@Override
protected void onPostExecute(String words) {
    super.onPostExecute(aVoid);
    text.setText(words);

}