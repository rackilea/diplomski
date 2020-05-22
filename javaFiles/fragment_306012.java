@Override
protected void onStart() {
    super.onStart();
    GoogleAnalytics.getInstance(this).reportActivityStart(this);
}

@Override
protected void onStop() {
    super.onStop();
    GoogleAnalytics.getInstance(this).reportActivityStop(this);
}