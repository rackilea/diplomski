//...
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //...
    Uri uri = getIntent().getData();

    //...
    webView.loadUrl(uri.toString());
}