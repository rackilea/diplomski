// Call method in js or html
 Android.getImageUrl("text");

    // add this line in main activity.    
     webView.addJavascriptInterface(new JavaScriptInterface(this), "Android");

    // js value get in this method.(add this method in activity)
    public class JavaScriptInterface {
                Context mContext;

                JavaScriptInterface(Context c) {
                    mContext = c;
                }

                @JavascriptInterface
                public void getImageUrl(String text) {
        // js value get here.
                    }
                }
            }