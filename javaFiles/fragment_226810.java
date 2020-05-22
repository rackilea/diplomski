String html ="<p>one</p><p>two</p><p>three</p><p>four</p><p>five</p>";
Document document = Jsoup.parse(html);
Elements paragraphs = document.select("p");

Collections.sort(paragraphs, new Comparator<Element>() {
    @Override
    public int compare(Element e1, Element e2) {
        return e1.ownText().compareTo(e2.ownText());
    }
});

System.out.println(paragraphs);