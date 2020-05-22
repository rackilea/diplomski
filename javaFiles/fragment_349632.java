@Override
    protected void onProgressUpdate(Integer... p) {
        super.onProgressUpdate(p);

        if ((int)progressBar.getTag()==position) {
            progressBar.incrementProgressBy(p[0]);
            progressBar.setProgress(p[0]);
        }


    }