webBrowser.addWebBrowserListener(new WebBrowserListener() {
            public void loadingProgressChanged(WebBrowserEvent wbe) {
                JWebBrowser wb = wbe.getWebBrowser();
                String pageUrl = wb.getResourceLocation();
                int progress = wb.getLoadingProgress();
                if (progress == 100) {
                    String jsCommand = "";
                    ....
                    wb.executeJavascript(jsCommand);

                }
            }
        }
...