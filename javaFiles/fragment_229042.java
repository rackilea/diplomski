import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebActivity extends Activity {

    public static int WEB_APP = 0;

    private static int REQUEST_FOR_ACTIVITY_CODE_SCAN = 1000;
    private static String qr_data = "";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webview = (WebView) findViewById(R.id.aw_webView);

        WebAppInterface jsInterface = new WebAppInterface();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.addJavascriptInterface(jsInterface, "WebAppInterface");
        webview.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Scan QR
        if (requestCode == REQUEST_FOR_ACTIVITY_CODE_SCAN) {
            if (resultCode == Activity.RESULT_OK) {
                qr_data = data.getStringExtra("qr_data");

                Log.d("QR", qr_data);
            }
        }
        WEB_APP = 0;
    }

    public class WebAppInterface {

        WebAppInterface() {}

        @JavascriptInterface
        public  String startScan() {
            Intent intent = new Intent(WebActivity.this, ScanActivity.class);
            WEB_APP = 1;

            startActivityForResult(intent, REQUEST_FOR_ACTIVITY_CODE_SCAN);

            while(WEB_APP == 1) {}

            Log.d("qr_return", qr_data);

            return qr_data;
        }
    }
}