@Override
protected void onPause() {
    adView.pause();
    super.onPause();
}



@Override
protected void onResume() {
    super.onResume();
    adView.resume();
}