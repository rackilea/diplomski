mWebView.setPictureListener(new MyPictureListener());
//... and then later on....
class MyPictureListener implements PictureListener {

    @Override
    public void onNewPicture(WebView view, Picture arg1) {
      // put code here that needs to run when the page has finished loading and
      // a new "picture" is on the webview.      
    }    
}