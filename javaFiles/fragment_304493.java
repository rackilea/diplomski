if(isOnline()){
        showCustomProgressDialog();
        WebView wb=(WebView)findViewById(R.id.webViewReader);
        RelativeLayout parent=(RelativeLayout)wb.getParent();
        parent.setVisibility(View.VISIBLE);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setDomStorageEnabled(true);
        wb.addJavascriptInterface(theInterface, "INTERFACE");
        wb.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        wb.getSettings().setSupportMultipleWindows(true);
        wb.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1: it-IT) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        wb.loadUrl("file:///android_asset/index.html");
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                super.shouldOverrideUrlLoading(view,url);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                try {
                    JSONObject root = new JSONObject(home.getStringFromFile(getFilesDir() + "/" + home.DASHBOARDJSONFILENAME));
                    JSONObject innerObj = root.getJSONObject("dashboard").getJSONObject("lastarticle");
                    innerObj=new parseArticleFromUrl().execute("https://www.readability.com/api/content/v1/parser?url="+innerObj.getString("link").replace("\\/", "/")+"&token=YOURTOKEN").get();
                    String a="Nothing found";
                    if(innerObj!=null){
                            String content = innerObj.getString("content");
                            if(content!=null){
                                Document doc=Jsoup.parse(content);
                                a=doc.text();
                            }
                    }
                    StringTokenizer tokens = new StringTokenizer(a, " ");
                    for(;tokens.hasMoreTokens();)
                    {
                        String curr_token=tokens.nextToken();
                        curr_token = curr_token.replaceAll("\"", "\\\\\"");
                        view.loadUrl("javascript:addWords('"+curr_token+"');");
                        view.loadUrl("javascript:addWords(' ');");
                    }
                    ldialog.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }