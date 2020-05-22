String url = "http://stackoverflow.com/questions/7311269"
             + "/java-print-any-detail-of-html-element";
Document doc = Jsoup.connect(url).get();
Elements divs = doc.select("div");
int i = 0;
for (Element div : divs) {
    System.out.format("Div #%d:\n", ++i);
    for(Attribute attr : div.attributes()) {
        System.out.format("%s = %s\n", attr.getKey(), attr.getValue());
    }
}