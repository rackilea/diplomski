public class AsyncStatus extends AsyncTask<String, String, StringBuilder> {

    public asyncResponse delegate=null;

    public void setDelegate(asyncResponse delegate){
            this.delegate=delegate;
    }

    @Override
    protected void onPostExecute(StringBuilder result) {
        super.onPostExecute(result);

        delegate.processFinish(result.toString());


    }
}