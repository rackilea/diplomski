@Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
view.loadUrl(url);
           /* if (Uri.parse(url).getHost().equals("www.laughonlyblog.wordpress.com/about/")) {
                //open url contents in webview
                return false;
            } else {
                //here open external links in external browser or app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            } */
return true;
        }