class fetcher extends AsyncTask<Void,Void, Void> {
String txtValue;

@Override
protected Void doInBackground(Void... arg0) {

    try {

        String value = "https://mywebpage.net/";
        Document document = Jsoup.connect(value).followRedirects(false).timeout(30000).get();
        Element p= document.select ("p.testoprezzo").first();
        txtValue = p.text();




    } catch (Exception e) {
        // TODO Auto-generated catch block
        txtValue = null;
        e.printStackTrace();
    }

    return null;
}

@Override
protected void onPostExecute(Void aVoid) {
    super.onPostExecute(aVoid);


    TextView valore = findViewById(R.id.textView4);
    valore.setText(txtValue);
}