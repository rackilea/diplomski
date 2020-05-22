class MyTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
      try {
        return seismic_text.getUrlContents(url);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return null;
    }

    @Override
    protected void onPostExecute(String result) {
      super.onPostExecute(result);
      // TODO handle result here
    }
  }