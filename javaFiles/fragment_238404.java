public class MultipleAsyncTask extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        runMultipleAsyncTask(); // Start Async Task
    }
    private void runMultipleAsyncTask() // Run Multiple Async Task
    {
        FirstAsyncTask asyncTask = new FirstAsyncTask(); // First
        if(AppUtil.isCurrentVersionHoneycombAndAbove()) // Above Api Level 13
        {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else // Below Api Level 13
        {
            asyncTask.execute();
        }
        SecondAsyncTask asyncTask2 = new SecondAsyncTask(); // Second
        if(AppUtil.isCurrentVersionHoneycombAndAbove())// Above Api Level 13
        {
            asyncTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else // Below Api Level 13
        {
            asyncTask2.execute();
        }
    }
    //Start First Async Task:
    private class FirstAsyncTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute()
        {
            Log.i("AsyncTask" ,"FirstOnPreExecute()");
        }
        @Override
        protected Void doInBackground(Void... params)
        {
            for(int index = 0; index < 50; index++)
            {
                Log.i("AsyncTask" ,"FirstAsyncTask");
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException exception)
                {
                    exception.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result)
        {
            Log.d("AsyncTask" ,"FirstonPostExecute()");
        }
    }
    //Start Second Async Task:
    private class SecondAsyncTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute()
        {
            Log.i("AsyncTask" ,"SecondOnPreExecute()");
        }
        @Override
        protected Void doInBackground(Void... params)
        {
            for(int index = 0; index < 50; index++)
            {
                Log.d("AsyncTask" ,"SecondAsyncTask");
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException exception)
                {
                    exception.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result)
        {
            Log.d("AsyncTask" ,"SecondOnPostExecute()");
        }
    }
}