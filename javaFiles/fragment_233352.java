public class WebviewActivity extends Activity { 
  WebView webview; 
        @Override  
        public void onCreate(Bundle savedInstanceState) {  
            super.onCreate(savedInstanceState);
            setContentView(R.layout.webview);  

            webview= (WebView) findViewById(R.id.webView1);  
            webview.loadUrl("file:///android_asset/your file_name.html"); 
        }  
    }