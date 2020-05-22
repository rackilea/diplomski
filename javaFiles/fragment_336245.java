@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_eight, container, false);
    mWebView = (WebView)     mWebView.findViewById(R.id.fragment_eight_webview);
    WebSettings webSettings = mWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    mWebView.loadUrl("http://facebook.com/");
}