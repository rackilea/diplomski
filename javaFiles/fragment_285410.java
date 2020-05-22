private class AsyncTaskRunner extends AsyncTask<String, String, String> {

     private WeakReference<Context> contextWeakReference;

     public FetchData (Content context) {
        contextWeakReference = new WeakReference<>();
     }

     private void doSomething() {
        // We have the context from the WeakReference
        Context context = contextWeakReference.get();
        DateUtils.formatDateTime(context, ...);
     }
}