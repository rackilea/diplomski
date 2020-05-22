public class JavaScriptInterface {
    private WebView mAppView;
    private DroidGap mGap

    public JavaScriptInterface (DroidGap gap, WebView view)
    {
        mAppView = view;
        mGap = gap;
    }

    public void doEmail(){
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/html");
        sendIntent.putExtra(android.content.Intent.EXTRA_TEXT,"test text");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT,"test subject");
        sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        sendIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://test co.html"));
        startActivity(Intent.createChooser(sendIntent, "Send email..."));
    } 
}