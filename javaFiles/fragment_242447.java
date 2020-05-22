@Override
protected void onResume() {
    ...
    mCallback = new Runnable() { ... };
    getContentView().postDelayed(mCallback, mDelay);
}