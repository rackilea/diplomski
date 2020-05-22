@Override
protected void onDestroy() {
    super.onDestroy();
    if (mSubscription != null) {
        mSubscription.unsubscribe();
    }
}