public boolean shouldOverrideUrlLoading(WebView webView, String url) {
    if(url.indexOf("yourcompanydomain.com") > -1 ) return false;

    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    activity.startActivity(intent);
    return true;
}