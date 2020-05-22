private void startAsyncTaskInParallel(MyAsyncTask task) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    else
        task.execute();
}