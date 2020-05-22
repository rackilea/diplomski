public class InstallUninstallReceiver extends BroadcastReceiver
    {
        private static final String TAG = InstallUninstallReceiver.class.getSimpleName();

        @Override
        public void onReceive(Context context, Intent intent)
        {
           startLoaderAsyncTask();
        }
private LoaderAsyncTask mLoaderAsyncTask;
private void startLoaderAsyncTask()
    {
        if(mLoaderAsyncTask != null)
        {
            mLoaderAsyncTask.cancel(true);
            mLoaderAsyncTask = null;
        }
        if(mLoaderAsyncTask == null)
            mLoaderAsyncTask = new LoaderAsyncTask();
        mLoaderAsyncTask.execute();
    }
    }