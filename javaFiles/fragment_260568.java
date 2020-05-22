private class MyAsyncTask extends AsyncTask<Void, Void, Void>
{
    @Override
    protected Void doInBackground(Void... params) {
        hostPhoto();
        return null;
    }
   @Override
   protected void onPostExecute(Void result) {
        post(text+" "+link);
    }
 }