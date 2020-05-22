WebClient webClient = new WebClient(BrowserVersion.CHROME);
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

    HtmlPage page = webClient.getPage("https://scholar.google.com/");

    HtmlInput searchBox = (HtmlInput) page.getElementById("gs_hp_tsi");
    searchBox.setValueAttribute("internet of things for smart cities");

    HtmlButton googleSearchSubmitButton = page.getElementByName("btnG");
    page = googleSearchSubmitButton.click();

    HtmlAnchor anchor = page.getAnchorByText("Cite");
    anchor.click();

    webClient.waitForBackgroundJavaScript(5000);

    HtmlAnchor linkBibTex = page.getAnchorByText("BibTeX");

    TextPage neededPage = linkBibTex.click();

    System.out.println(neededPage.getContent());

    webClient.close();