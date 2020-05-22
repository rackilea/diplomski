Handler ha=new Handler();
ha.postDelayed(new Runnable() {
    @Override
    public void run() {
        webview.loadUrl("your url");
        ha.postDelayed(this, 5000);
    }
}, 5000);