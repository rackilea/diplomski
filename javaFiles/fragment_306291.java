WebView myWebView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    //creating and referencing our View
    View view = inflater.inflate(R.layout.fragment_home,container,false);

    //The key difference is we reference our view with the findViewById
    myWebView = (WebView) view.findViewById(R.id.webView);
    WebSettings webSettings = myWebView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    myWebView.loadUrl("http://www.google.com");
    myWebView.setWebViewClient(new WebViewClient());

    return view;
}