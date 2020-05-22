private static class MatchWordsTask extends AsyncTask<String[], Integer, Boolean> {
    private WeakReference<ProgressBar> mProgressBar;
    private String[] mArray;

    MatchWordsTask(ProgressBar progressBar, String[] array) {
        mProgressBar = new WeakReference<ProgressBar>(progressBar);
        mArray = array;
    }

    protected Boolean doInBackground(String[]... arrays) {
        for (int i = 0; i < mArray.length; i++) {
            publishProgress(((i + 1) / mArray.length) * 100);

            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    protected void onProgressUpdate(Integer... progress) {
        mProgressBar.get().setProgress(progress[0]);
    }

    protected void onPostExecute(Boolean matches) {
        Log.d(TAG, "Matches: " + matches);
    }
}