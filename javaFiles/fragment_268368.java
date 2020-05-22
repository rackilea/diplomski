public class WebAppInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Get the value */
    @JavascriptInterface
    public int getValue() {
        return value
    }
}