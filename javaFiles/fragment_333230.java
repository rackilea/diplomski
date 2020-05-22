final Document doc = Jsoup.parse(content);
final Elements elements = doc.select("body > *:not(img)");
final Iterator<Element> iterator = elements.iterator();
final StringBuilder finalContent = new StringBuilder();

Element current;
while (iterator.hasNext() && !(current = iterator.next()).tagName().startsWith("a")) {
    finalContent.append(current.toString());
    String siblingText = current.nextSibling().attr("text").trim();
    if (!siblingText.isEmpty()) {
        finalContent.append(siblingText);
    }
}

System.out.println(finalContent);