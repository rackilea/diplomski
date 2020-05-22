public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...

        // Start the task here
        new URLDataLoader().execute(theURL);
    }

    private class URLDataLoader extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... params) {
            URL theURL = params[0];
            // Do your network stuff here to get the data
            return theData;
        }

        @Override
        protected void onPostExecute(String data) {
            // Use the data here
        }
    }
}