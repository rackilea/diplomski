InputStream is = new FileInputStream(filename) {
    @Override
    public int read() throws IOException {
        return 0;
    }
};

  doc = Jsoup.parse(is, "UTF-8", "", Parser.xmlParser());


if (doc.getElementsByTag("note").isEmpty()) {
    doc = Jsoup.parse(is, "UTF-8", "", Parser.xmlParser());
    if (doc.getElementsByTag("note").isEmpty()) {
        System.out.println("Please check that your file is encoded in UTF-8 or UTF-16 and contains notes.");
    }
}