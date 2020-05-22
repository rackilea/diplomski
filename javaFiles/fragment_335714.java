public static Feed parse(URL url, String userAgent) throws IOException, FeedIOException, FeedXMLParseException, UnsupportedFeedException {
    try {
        URLConnection con = url.openConnection();
        if (userAgent != null) {
            con.addRequestProperty("User-Agent", userAgent);
        }
        con.connect();
        InputStream is = con.getInputStream();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(is);
        int code = FeedRecognizer.recognizeFeed(document);
        switch (code) {
        case FeedRecognizer.RSS_1_0:
            return TypeRSS_1_0.feed(url, document);
        case FeedRecognizer.RSS_2_0:
            return TypeRSS_2_0.feed(url, document);
        case FeedRecognizer.ATOM_0_3:
            return TypeAtom_0_3.feed(url, document);
        case FeedRecognizer.ATOM_1_0:
            return TypeAtom_1_0.feed(url, document);
        default:
            throw new UnsupportedFeedException();
        }
    } catch (DocumentException e) {
        throw new FeedXMLParseException(e);
    }
}