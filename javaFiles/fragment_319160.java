private void Authentication(){

    class MyJavaScriptInterface {

        @JavascriptInterface
        public void showHTML(String content) {
            // grants access based on authorization level

            }
        }
    }

    // open up the login page
    final WebView wv = (WebView)findViewById(R.id.login_webview);

    wv.getSettings().setJavaScriptEnabled(true);

    wv.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT");

    wv.setWebViewClient(new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {

            //once page is finished loading, check id="role" pass that value to showHTML
            if(url.contains(getString(R.string.loginURL))) {
                wv.loadUrl("javascript:(function() { " +
                        "window.HTMLOUT.showHTML(document.getElementById('role').innerHTML);" +
                        "})()");

            }

        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description,
                                    String failingUrl) {
            Log.w("LoginActivity: ", description);
        }
    });

    wv.loadUrl(getString(R.string.loginURL));

}