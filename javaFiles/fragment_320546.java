import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
WebView webView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webView = findViewById(R.id.web);



    webView.loadUrl("http://www.google.com");
    WebSettings webSettings = webView.getSettings();
    webView.getSettings().setJavaScriptEnabled(true);

    webView.setWebViewClient(new WebViewClient());


}


@Override
public void onBackPressed() {
    if(webView.canGoBack()){
        webView.goBack();
    }
    else
    {
        finish();
    }
}
}