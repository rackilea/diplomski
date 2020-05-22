public class SplashActivity extends AppCompatActivity {

private ProgressBar mProgress;

@Override
protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.activity_splash);
    mProgress = (ProgressBar) findViewById(R.id.progressBar);
    new DoWork().execute(this);
}
   protected class DoWork extends AsyncTask<Context, Integer, Void> {
        @Override
        protected String doInBackground(Context... params) {
             //do some task say 20% of complete task
              publishProgress(20);
            //do some task say 50% of complete task
        publishProgress(50);
        //do some task say 100% of complete task
        publishProgress(100);
            return null;
        }

        //Called just before execution begins
        @Override
        protected void onPreExecute() {
            Log.i("AsyncTask", "onPreExecute()");
        mProgress.show();
            super.onPreExecute();
        }

        //called from the publish progress
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values); 
        mProgress.setProgress(values[0]);           
        }

    // when execution is completed
        @Override
        protected void onPostExecute(Void param) {
            super.onPostExecute(result);
            mProgress.dismiss();
        }
    }
}