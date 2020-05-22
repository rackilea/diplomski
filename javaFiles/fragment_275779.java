if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB) {
  myTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
}
else {
  myTask.execute();
}