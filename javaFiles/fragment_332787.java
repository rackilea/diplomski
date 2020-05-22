public class YourAsyncTask extends AsyncTask<...> {

    Handler myHandler;

    public YourAsyncTask(Handler myHandler) {
        this.myHandler = myHandler;
    }

    ...

    @Override
    protected void onProgressUpdate(Message... values) {
        myHandler.sendEmptyMessage(values[0]);
    }
}