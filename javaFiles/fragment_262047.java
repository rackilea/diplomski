public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView myWebView = findViewById(R.id.webView);
        final WebSettings settings = myWebView.getSettings();

        settings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                final String injectedJs = "javascript:(function(){" + injectedJs() + "})()";
                myWebView.loadUrl(injectedJs);
            }
        });

        myWebView.addJavascriptInterface(
                new Object() {
                    @JavascriptInterface
                    public void onClick(String param) {
                        Toast.makeText(MainActivity.this, param, Toast.LENGTH_LONG).show();
                    }
                },
                "appHost"
        );
        myWebView.loadUrl("https://google.com");
    }

    // Javascript code to inject on the Web page
    private String injectedJs() {
        BufferedReader stream = null;
        StringBuilder jsBuilder = new StringBuilder();
        try {
            stream = new BufferedReader(new InputStreamReader(getAssets().open("js.js")));
            String line;
            while ((line = stream.readLine()) != null) {
                jsBuilder.append(line.trim());
            }
            return jsBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}