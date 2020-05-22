@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    WebView siteViewer = (WebView) rootView.findViewById(R.id.webView);
    if(siteViewer != null)
        siteViewer.loadUrl("http://www.website.com");

    return rootView;
}