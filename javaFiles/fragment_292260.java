public class MainActivity extends DroidGap {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setIntegerProperty( "splashscreen", R.drawable.splash );

        JavaScriptInterface jsi = new JavaScriptInterface(this, appView);
        appView.addJavascriptInterface(jsi, "Android");

        super.loadUrl("file:///android_asset/www/index.html", 1000);
    }
}