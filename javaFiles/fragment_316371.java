long mLastInsertedID;

private static class InsertLogAsyncTask extends AsyncTask<LogEntity, Void, Long>{
    private LogDao logDao;
    private InsertLogAsyncTask(LogDao logDao){
        this.logDao = logDao;
    }
    @Override
    protected Long doInBackground(LogEntity... logEntities) {
        //you are now off the UI thread
        logDao.insert(logEntities[0]);
        return logDao.insert(logEntities[0]);
    }

    @Override
    protected void onPostExecute(Long result) {
        //Do whatever you like with the result as you are back on the UI thread
        mLastInsertedID = result;
    }
}