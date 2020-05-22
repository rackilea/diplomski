Map<String, Long> counts = new HashMap<>();
String html = " your html string goes here ";    

Document doc = Jsoup.parse(html);

Elements elements = document.body().select("*");
recursiveWalk(elements, counts);

// your map here, sort it

// method to walk the document
private void recursiveWalk(List<Element> elements, Map<String, Long> counts) {
    for (Element el : elements) {
        String tag = el.tagName();
        long number = counts.getOrDefault(tag, 0L) + 1;
        counts.put(tag, number);
        recursiveWalk(elements.children(), counts);
    }
}