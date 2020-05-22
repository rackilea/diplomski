private class cleanHtml extends AsyncTask<Void, Void, Void>{

    @Override
    protected Void doInBackground(Void... arg0) {
        try {
            HtmlCleaner cleaner = new HtmlCleaner();
            String url = "https://www.easistent.com/urniki/263/razredi/16515";
            TagNode node = cleaner.clean(new URL(url));
            CleanerProperties props = cleaner.getProperties();
            String fileName = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.whizzapps.stpsurniki/cleaned.html";
            new PrettyXmlSerializer(props).writeToFile(node, fileName, "utf-8");
            Log.i("TAG", "AsyncTask done!");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}