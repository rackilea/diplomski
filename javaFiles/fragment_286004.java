public class WebAppInterface
 {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c)
        {
            mContext = c;
        }

        public void storeText(String text)
        {
            //TODO  save text
            Toast.makeText(mContext, text, Toast.LENGTH_LONG).show();
        }
    }

WebView webview=(WebView)findViewById(R.id.webview);
webview.getSettings().setJavaScriptEnabled(true);
webview.addJavascriptInterface(new WebAppInterface(this), "Android");