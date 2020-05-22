@Override
    protected void onPostExecute(InputStream inputStream) {

        mPDFview.fromStream(inputStream).onLoad(new OnLoadCompleteListener() {
            @Override
            public void loadComplete(int nbPages) {
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
                progressBar.setVisibility(View.GONE);
            }
        }).load();

    }