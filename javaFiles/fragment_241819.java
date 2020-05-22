final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17,
                YOUR_PROXY_HOST, YOUR_PROXY_PORT);

        WebRequest request = new WebRequest(
                new URL(
                        "http://bitcoincharts.com/charts/btceUSD#rg60ztgSzm1g10zm2g25zv"));

        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.setJavaScriptTimeout(10000);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setTimeout(10000);

        HtmlPage page = webClient.getPage(request);
        webClient.waitForBackgroundJavaScript(30000);

        List<HtmlAnchor> anchors1 = page.getAnchors();
        HtmlAnchor link2 = null;
        for (HtmlAnchor anchor : anchors1) {
            //System.out.println(anchor.asText());
            if (anchor.asText().indexOf("Load raw data") > -1) {
                link2 = anchor;
                break;
            }
        }
        page = link2.click();