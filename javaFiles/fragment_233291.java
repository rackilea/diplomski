public void onBackPressed(){

 if (mWebView.canGoBack()) {
      mWebView.goBack();
 } else {
      finish();
 }
}