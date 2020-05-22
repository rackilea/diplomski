@Override
protected void onDestroy() {
    super.onDestroy();
    mCsr.close();
}

@Override
protected void onResume() {
    super.onResume();
    manageListView();
}