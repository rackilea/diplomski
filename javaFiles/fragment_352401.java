@Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
        getSupportActionBar().setTitleColor(Color.RED);
    }