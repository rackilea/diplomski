private static final Handler handler = new Handler();

private final Runnable action = new Runnable() {
    @Override
    public void run() {
        WebRequest wr = new WebRequest(this.serviceURL, this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            wr.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, processType, newMap);
        else
            wr.execute(processType, newMap);
    }
};

@Override
public void onCreate(){
    super.onCreate();
    handler.post(action);
}