private static class FindTargetByIDAsyncTask extends AsyncTask<Integer, Void, Targets> {

    private final TargetsDao mAsyncTaskDao;
    private final Callback callback;

    FindTargetByIDAsyncTask(TargetsDao dao, Callback callback) {
        mAsyncTaskDao = dao;
        this.callback = callback;
    }


    @Override
    protected Targets doInBackground(Integer... integers) {
        return mAsyncTaskDao.findTargetById(integers[0]);
    }

    @Override
    protected void onPostExecute(Targets targets) {
        callback.onSuccess(targets);
    }
}