wv.setWebViewClient(new WebViewClient() {
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        Toast.makeText(getActivity().getApplicationContext(), "Error", Toast.LENGTH_LONG).show();


        webView.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
   }

});