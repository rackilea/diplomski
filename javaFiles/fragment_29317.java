@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
        ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        if (matches != null && matches.size() > 0) {
            String searchWrd = matches.get(0);
            if (!TextUtils.isEmpty(searchWrd)) {
                searchView.setQuery(searchWrd, false);
            }
        }

        return;
    }
    super.onActivityResult(requestCode, resultCode, data);
}