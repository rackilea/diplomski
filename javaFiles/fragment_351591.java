public class AsyncPost extends AsyncTask<Object, Integer, String> {
    private AsyncPostListener listener;
    ....
    public AsyncPost(AsyncPostListener listener){
        this.listener = listener;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(listener != null)
            listener.continueWith(s);
    }
}