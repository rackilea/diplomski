public class ZipHelper extends AsyncTask<Void, Void, Integer>
{
    private String filename;
    private AsyncTaskListener listener;
    private File file;
    public ZipHelper(String filename, File file, AsyncTaskListener listener)
    {
        this.filename = filename;
        this.file = file;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute()
    {
        //stuff here
    }

    @override
    protected Integer doInBackground(Void... params)
    {
        //Background stuff here
    }

    @Override
    protected void onPostExecute(Integer... result)
    {
        listener.onTaskComplete();
    }
}