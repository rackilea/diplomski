EZAsyncTask ezTask = new EZAsyncTask(new AsyncTaskListener() {
    @Override
    public void onCompletion(String result)
    {
        // TODO handle response
    }
    });
ezTask.execute();