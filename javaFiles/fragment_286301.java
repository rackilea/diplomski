public class MyJavaScriptInterface {
             Context mContext;

                MyJavaScriptInterface(Context c) {
                    mContext = c;
                }
                @JavascriptInterface
                public void showToast(String toast){
                    Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
                }
    }