public class WebViewExtended extends WebView {
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        // This line fixes some issues but introduces others, YMMV.
        // super.onCreateInputConnection(outAttrs);

        return new BaseInputConnection(this, false);
    }
}