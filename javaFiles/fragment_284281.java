Document document = Jsoup.parse(str);
Elements allElements = document.getAllElements();

for (Element element : allElements) {
    String tagName = element.tagName();
    String text = element.text();
    if (tagName.equalsIgnoreCase("name")) {
        System.out.println("name " + text);
    } else if (tagName.equalsIgnoreCase("host")) {
        System.out.println("host " + text);
        System.out.println("ip " + element.attr("ip"));
    }
}