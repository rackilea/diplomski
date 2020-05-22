private class MtDownloadTask extends AsyncTask<Void, Void ,Void>{

    URL someUrl = new URL("your url String"); //
    File someFile = new File("your file, where you want to save the data");

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
        FileUtils.copyURLToFile(url, file);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

}