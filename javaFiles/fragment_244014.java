this.handler = new Handler(Looper.getMainLooper());
this.handler.postDelayed(new Runnable()
    {
        @Override
        public void run()
        {
            // create a webview
            final WebView webView = new WebView(context);

            // etc
        }
    });