webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://oyster.tfl.gov.uk/oyster/entry.do");


        webview.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:document.getElementsByName('j_username')[0].value = '"+ausername+"'");
                view.loadUrl("javascript:document.getElementsByName('j_password')[0].value = '"+apassword+"'");
                view.loadUrl("javascript:document.forms[0].submit()");
            }
        });