import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TestWebViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new MyWebViewClient());
    }
}


class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.contains("somePartOfYourUniqueUrl")){ // Could be cleverer and use a regex
            return super.shouldOverrideUrlLoading(view, url); // Leave webview and use browser
        } else {
            view.loadUrl(url); // Stay within this webview and load url
            return true;
        }
    }
}