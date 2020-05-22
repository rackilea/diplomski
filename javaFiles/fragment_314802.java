Document doc = Jsoup.parse(h);
Element firstDiv = doc.select("div.clear").first();
Elements news = new Elements();
Element item = firstDiv.nextElementSibling();
while (item != null && !(item.tagName().equals("div") && item.className().equals("clear"))) {
    news.add(item);
    item = item.nextElementSibling();
}

System.out.println(String.format("Found %s items", news.size()));
for (Element element : news) {
    System.out.println(element.text());
}