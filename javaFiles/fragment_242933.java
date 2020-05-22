public class TalkToServer extends AsyncTask<String, String, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected String doInBackground(String... params) {
    //do your work here
        return something;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
           // do something with data here-display it or send to mainactivity
}