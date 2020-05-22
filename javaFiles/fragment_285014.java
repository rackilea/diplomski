public void loadArticleWithHTML (){
    Thread downloadThread = new Thread() {
        public void run() {
            try {
                doc = Jsoup.connect("http://en.wikipedia.org/").get();
                element = doc.select("#mp-itn b a");

            } catch (java.io.IOException e){
                e.printStackTrace();
            }
            if (element == null) {
                Log.e("error", "There is a problem with the selection");
            } else {
                // post a new Runnable from a Handler in order to run the WebView loading code from the UI thread
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mWebView.loadData(element.html(), "text/html", "UTF-8");
                    }
                });
            }
        }
    };

    mWebView.setWebViewClient(new WebViewClient() {
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
        }
    });

    downloadThread.start();
}