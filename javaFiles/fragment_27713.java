public class CustomWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            showProgressBar();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            hideProgressBar();
        }
    }


    webViewClient.setWebViewClient(new CustomWebViewClient());