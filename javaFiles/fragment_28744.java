@Override
protected void onPause() {
    super.onPause();

    String url = webView.peekAtUrlStack();
    webView.handlePause(true);

    Bundle out = new Bundle();
    webView.saveState(out);
    out.putString("url", url);

    saveToPreferences(out);
}