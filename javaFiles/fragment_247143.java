private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls) {
      //Download your pictures and prepare the text
      return response;
    }

    @Override
    protected void onPostExecute(String result) {
      textView.setText(result);
      //Better:
      ImageView.setbackground(....)
    }
  }

}