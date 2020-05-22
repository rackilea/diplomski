Elements fooElements = Jsoup
                .parse(html)
                .body().select(".foo");

Elements elements = new Elements()
for(Element el : fooElements) {
    elements.add(el.select(".bar").first());
}