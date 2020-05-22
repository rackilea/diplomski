final String url = "https://digital.utc.com/our-latest";

    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60)) {
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setCssEnabled(false);;
        webClient.getOptions().setJavaScriptEnabled(false);

        HtmlPage page = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(4_000);

        System.out.println(page.asXml());

        DomNodeList<DomElement> links = page.getElementsByTagName("a");
        for (DomElement domElement : links)
        {
            String href = domElement.getAttribute("href");
            System.out.println(domElement.asXml());
        }
    }