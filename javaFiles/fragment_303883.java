private static class deleteAsyncTask extends AsyncTask<Void, Void, Void> {

    private MessageDao mAsyncTaskDao;
    private String mPhoneNumber = null;

    public deleteAsyncTask(MessageDao dao) {
        mAsyncTaskDao = dao;
    }

    public deleteAsyncTask(MessageDao dao, String phoneNumber) {
        mAsyncTaskDao = dao;
        mPhoneNumber = phoneNumber;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        if (mPhoneNumber == null) {
            mAsyncTaskDao.deleteAll();
        }
        else {
            mAsyncTaskDao.delete(mPhoneNumber);
        }
        return null;
    }
}