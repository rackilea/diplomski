public List<NewsBean> getData(InputStream istream) {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();

            System.out.println("Builder : " + builder);

            Document doc = builder.parse(istream);
    Document doc = builder.parse(istream);
.....
}