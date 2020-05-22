private class BackgroundSplashTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... arg0) {
        try {
            Thread.sleep(SPLASH_SHOW_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i); finish();
    }

}