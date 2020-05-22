BrowserVersionFeatures[] bvf = new BrowserVersionFeatures[1];
    bvf[0] = BrowserVersionFeatures.HTMLIFRAME_IGNORE_SELFCLOSING;
    BrowserVersion bv = new BrowserVersion(
            BrowserVersion.NETSCAPE, "5.0 (Windows; en-US)",
            "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8",
            (float) 3.6, bvf);

    WebClient webClient = new WebClient(bv);
    webClient.setJavaScriptEnabled(true);