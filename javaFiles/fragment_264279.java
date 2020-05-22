public class TestActivity extends Activity{
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
    new DeviceSearcher().execute();
}

private class DeviceSearcher extends AsyncTask<Void, DeviceInformation ,Void>
{
    @Override
    protected void onPreExecute()
    {
        ....
        ....
        Some Changes that I need to do before calling Network Threads
        ....
        ....
    }
    @Override
    protected Void doInBackground(Void... arg0)
    {
        new Thread()
        {
            public void run()
            {
            ....
            ....//Network Thread
            ....

            publishProgress(device);//call to onProgressUpdate() method
            }
        }.start();
    return null;
    }
    @Override
    protected void onProgressUpdate(DeviceInformation... d)
    {
        super.onProgressUpdate(d[0]);
        /***
           * Changes in User Interface
           **/
    }
}