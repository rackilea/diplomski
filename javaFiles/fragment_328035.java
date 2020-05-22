@Override
    protected Void doInBackground(Void... params) {

mTwitter = new TwitterApp(context, twitter_consumer_key,twitter_secret_key);
Activity_name.this.runOnUiThread(new Runnable() {

          @Override
          public void run() {
        mTwitter.setListener(mTwLoginDialogListener);
          }
       });
        return null;
    }