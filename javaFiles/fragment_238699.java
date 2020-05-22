class MyAsyncTask extends AsyncTask {

    MyActivity activity;

    public MyAsyncTask(MyActivity a)
        this.activity = a;
    }

    @Override
    protected Object doInBackground(String... params) {
        try {       
            // do your stuff here

        } catch (ConnectionTimeoutException e) {
            publishProgress("timeout");
    }

    @Override
    protected void onProgressUpdate(String... values) {
        if(values[0].equals("timeout")
            activity.showToast("Ups, we have a timeout!", Toast.LENGTH_LONG); }
        }
    }
}