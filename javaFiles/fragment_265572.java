public DownloadWebPageTask(Callback callback) {
    this.callback = callback;
}

private Callback callback;

...

protected void onPostExecute(final String title) {
    callback.onModifiedTextView(title);
}