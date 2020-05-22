public class MainActivity implements ProcessData{
    interface ProcessData { void OnProcessData(long[] baLogData); }

    ProcessData _processData;
    YourAsyncTask task;

    public MainActivity(){
        _processData = this;
        task = new YourAsyncTask();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        task.exacute(new YourInputData());
    }

    private class YourAsyncTask extends AsyncTask<YourInputData, Integer, long[]> {
        protected Long doInBackground(YourInputData... urls) {
            // proccessing
        }

        protected void onProgressUpdate(Integer... progress) {
            // update progress
        }

        protected void onPostExecute(long[]result) {
            // setup result
        }
    }
}