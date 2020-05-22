webView.loadUrl("http://www.website.com");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    try {
                      URL urlObj = new URL(url);
                      if( (url.startsWith("http://www.website.com")) ) {
                        //Allow the WebView in your application to do its thing
                        return false;
                      } else {
                        //Pass it to the system, doesn't match your domain
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                        //Tell the WebView you took care of it.
                        return true;
                      }
                    }
                    catch (Exception e) {
                      e.printStackTrace();
                    }
                    return false;

                }
            });
            {

            }