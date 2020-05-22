myWebView.setWebChromeClient( new WebChromeClient(){
    public boolean onJsAlert( WebView view , String url , String message , android.webkit.JsResult result ){
         if(message.compareTo( "onFoo" ) == 0){
              foo();
              result.confirm();
    return true;
         }
         return false;
    }


}
);