public class MyAsyncTask extends AsyncTask<String, Void, JSONObject> {

   private ProgressBar mProgressBar;
   public ASynceResponse delegate = null;

       public MyAsyncTask() {
         this.delegate = delegate;
         this.mProgressBar = progressBar;
       }

       @Override
       protected void onPreExecute() {
          delegate.myOnPreExecute();
          mProgressBar.setVisibility(View.VISIBLE);
       }

       @Override
       protected JSONObject doInBackground(String... params) {
           return; 
       }

       @Override
       protected void onPostExecute(JSONObject data) {
           mProgressBar.setVisibility(View.GONE);
           delegate.processResults(data);
       }


       public interface ASyncResponse {
           void processResults(JSONObject data);
           void myOnPreExecute();
       }

   }