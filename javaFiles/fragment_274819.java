public class TestAsyncTask extends AsyncTask<Void, Void, Void> {
    private boolean mShouldCreateNewAsyncTask;
    private FragmentCallback mFragmentCallback;

    public TestAsyncTask(FragmentCallback fragmentCallback) {
        mFragmentCallback = fragmentCallback;
    }

    @Override
    protected Void doInBackground(Void... params) {
        /*
         * Do your loop or whatever and when you need to restart it set
         * mShouldCreateNewAsyncTask = true and return null.
         */

        mShouldCreateNewAsyncTask = true;

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (mShouldCreateNewAsyncTask) {
            mFragmentCallback.onTaskDone();
        }
    }
}