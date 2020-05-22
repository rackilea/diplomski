@Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
        int actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (actionBarTitleId > 0) {
            TextView title = (TextView) findViewById(actionBarTitleId);
            if (title != null) {
                title.setTextColor(Color.RED);
            }
        }
    }