try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
        String url = "http://www.gelbeseiten.de/schneider/hamburg";
        HtmlPage htmlPage = webClient.getPage(url);
        for (Object o : htmlPage.getByXPath("//span[@class='teilnehmertelefon']")) {
            System.out.println(((HtmlElement) o).asXml());
        }
    }