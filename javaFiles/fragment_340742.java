@Override
    public void onResume() {
        super.onResume();
        if(connected){
            webview.loadUrl("your url");
        }
    }