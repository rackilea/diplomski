public void run() {
    try {
        HttpAsyncTask mytask = new HttpAsyncTask();
        // PerformBackgroundTask this class is the class that extends AsynchTask
        mytask.execute( "https://www.google.com" );
    } catch (Exception ignore) {
        // TODO Auto-generated catch block
    }
}