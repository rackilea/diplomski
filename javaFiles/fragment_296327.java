@Override
protected void onDestroy() {
    searchBarEmployer.removeTextChangedListener(filterTextWatcher);
    super.onDestroy();

}