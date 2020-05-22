@Override
public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    Uri uri = request.getUrl();
    if (Objects.equals(uri.getScheme(), "whatsapp")) {
        try {
            Intent intent = Intent.parseUri(request.getUrl().toString(), Intent.URI_INTENT_SCHEME);
            if(intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    return super.shouldOverrideUrlLoading(view, request);
}