public class Main extends Activity {
  private WebView myWebView;
  private static final FrameLayout.LayoutParams ZOOM_PARAMS = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,Gravity.BOTTOM);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.webview);
    this.myWebView = (WebView) this.findViewById(R.id.webView);

    FrameLayout mContentView = (FrameLayout) getWindow().
    getDecorView().findViewById(android.R.id.content);
    final View zoom = this.myWebView.getZoomControls();
    mContentView.addView(zoom, ZOOM_PARAMS);
    zoom.setVisibility(View.GONE);

    this.myWebView.loadUrl("http://www.facebook.com");
  }
}