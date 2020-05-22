import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TestWebView extends Activity {
    private WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.full_screen_image_layout);

        webView = (WebView) findViewById(R.id.fullScreenImageWebView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);

        webView.setWebViewClient(new WebViewClient() {

            /*
             * (non-Javadoc)
             * 
             * @see
             * android.webkit.WebViewClient#onReceivedError(android.webkit.WebView
             * , int, java.lang.String, java.lang.String)
             */
            @Override
            public void onReceivedError(WebView view, int errorCode,
                    String description, String failingUrl) {
                // TODO Auto-generated method stub
                super.onReceivedError(view, errorCode, description, failingUrl);
                loadError();
            }
        });

        webView.loadUrl("http://www.google.com");
    }

    private void loadError() {
        String html = "<html><body><table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"
                + "<tr>"
                + "<td><div align=\"center\"><font color=\"red\" size=\"20pt\">Your device don't have active internet connection</font></div></td>"
                + "</tr>" + "</table><html><body>";
        System.out.println("html " + html);

        String base64 = android.util.Base64.encodeToString(html.getBytes(),
                android.util.Base64.DEFAULT);
        webView.loadData(base64, "text/html; charset=utf-8", "base64");
        System.out.println("loaded html");
    }

}