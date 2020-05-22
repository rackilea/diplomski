Document doc = Jsoup.parseBodyFragment(htmlString);
Elements inputs = doc.select("input");
for (Element el : inputs) {
  Attributes attrs = el.attributes();
  System.out.print("ELEMENT: " + el.tagName());
  for (Attribute attr : attrs) {
    System.out.print(" " + attr.getKey() + "=" + attr.getValue());
  }
  System.out.println();
}