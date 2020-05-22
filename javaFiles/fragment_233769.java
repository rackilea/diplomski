public class SendRequestAsyncTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        //runs in ui thread 
    }

    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub
        //perform network operations here it is the background thread
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        //runs in ui thread you can update the layout here
    }
}