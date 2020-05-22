public class AasyncTask extends AsyncTask{
public AsyncResponse delegate=null;

   @Override
   protected void onPostExecute(String result) {
      delegate.processFinish(result);
   }