class Downloader {
    public static void downloadAsync(Object object, String url, final ProgressBar progressBar ){
            // download thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // start download here
                // while download progresses
                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setSelection(<your progress value>);
                    }
                });
            }
        });
    }
}