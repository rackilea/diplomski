public void onModifiedTextView(final String title) {
    runOnUiThread(new Runnable() {
        public void run() {
            textView.setText(title);
            textView.invalidate(); // not even necessary
        }
    });
}