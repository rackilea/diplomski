private class SomeLoader extends AsyncTask<Void, Void, Integer> {

    private Activity activity;
    LoadingResultInterface loadingListener;

    public SomeLoader(Activity activity) {
        this.activity = activity;
        loadingListener = (LoadingResultInterface)activity;
    }

    protected final Integer doInBackground(Void... params) {
        // int result = someJob();
        return result;
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        loadingListener.onLoadingResult(result);
    }
}