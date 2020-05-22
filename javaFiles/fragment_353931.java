myWebView.post(new Runnable() {
    @Override
    public void run() {
        webviewLoadURL("file:///android_asset/test1.html");
    }
});