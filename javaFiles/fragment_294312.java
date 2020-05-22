public class MainActivity extends AppCompatActivity implements MyWebChromeClient.ProgressListener{
private WebView mWebView;
private ProgressBar mProgressBar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mWebView = (WebView) findViewById(R.id.webView);
    WebSettings webSettings = mWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);

    // add progress bar
    mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    mWebView.setWebChromeClient(new MyWebChromeClient(this));
    mWebView.setWebViewClient(new WebViewClient() {

        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);


            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgressBar.setVisibility(View.GONE);

        }


    });


}


@Override
public void onUpdateProgress(int progressValue) {
    mProgressBar.setProgress(progressValue);
    if (progressValue == 100) {
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}
}