@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (url.equalsIgnoreCase(/*your sitemap url*/)) {
        //use the above code
    }
    return true;
}