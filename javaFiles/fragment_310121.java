class MyJavaScriptInterface {
        @JavascriptInterface
        @SuppressWarnings("unused")
        public void processHTML(final String html) {
            myWebview.post(new Runnable() {
                @Override public void run() {
                    TextView text = findViewById(R.id.textView); text.setText(html);
                }
            });
        }
    }