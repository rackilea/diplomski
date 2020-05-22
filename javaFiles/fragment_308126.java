String url = "https://miami-dade.realtaxdeed.com/index.cfm?zaction=AUCTION&Zmethod=PREVIEW&AUCTIONDATE=07/24/2018";

try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_60)) {
    webClient.setWebConnection(new FalsifyingWebConnection(webClient) {
        @Override
        public WebResponse getResponse(WebRequest webRequest) throws IOException {
            if (webRequest.getUrl().getPath().endsWith("jquery-1.6.1.min.js")) {
                String jQuery = FileUtils.readFileToString(new File("jquery-1.6.1.js"));
                return createWebResponse(webRequest, jQuery, "application/javascript");
            }
            return super.getResponse(webRequest);
        }
    });

    HtmlPage previewItemsForSalePage = webClient.getPage(url);
    webClient.waitForBackgroundJavaScript(1000);

    System.out.println("----------------");
    System.out.println(previewItemsForSalePage.asText());
}