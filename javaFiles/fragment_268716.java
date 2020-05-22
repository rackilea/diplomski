public class MyTask extends AsyncTask<Void, Void, Void>{

@Override
protected Void doInBackground(Void... params) {
    handler.processFeed();
    return null;
}

@Override
protected void onPostExecute(Void result) {
    resetDisplay (handler.getTitle(), handler.getDate(), handler.getImage(), handler.getDescription());
    super.onPostExecute(result);
}
}