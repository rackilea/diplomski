URL startUrl = ...; 
Set<String> addedPages = new HashSet<>();
List<URL> urls = new ArrayList<>();
addedPages.add(startUrl.toExternalForm());
urls.add(startUrl);
while (!urls.isEmpty()) {
     // retrieve url not yet crawled
     URL url = urls.remove(urls.size()-1);

     Document doc = JSoup.parse(url, TIMEOUT);
     Elements allLinksOnPage = doc.select("a");
     for (Element e : allLinksOnPage) {
        // add hrefs
        URL absUrl = new URL(e.absUrl("href"));

        switch (absUrl.getProtocol()) {
            case "https":
            case "http":
                if (absUrl.toExternalForm().startsWith(getURL) && addedPages.add(absUrl.toExternalForm())) {
                    // add url, if not already added
                    urls.add(absUrl);
                }
        }
    }
}