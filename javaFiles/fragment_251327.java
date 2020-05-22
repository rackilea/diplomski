public String getText(){
    try{
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Israel").get();
        Elements paragraphs = doc.select("p:not(:has(#coordinates))");
        Element firstParagraph = paragraphs.first();
        return firstParagraph.text();
    }
    catch (IOException e) {
        return "Failed";
    }
}