public class MyPlugin extends CordovaPlugin{
    public void executeGlobalJavascript(final String jsString){
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:"+jsString);
            }
        });
    }

    public void someMethod(){
        executeGlobalJavascript("window.alert(\"log something\");";
    }
}