@Override
public void onReceivedError (WebView view, int errorCode, String description, String failingUrl)
{
    counter++;
    if(150 == counter){
        mainActivity.KillThisThenStartNewOne();
    }
    view.loadUrl("file:///android_asset/check.html");
}