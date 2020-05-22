public static void h1s() {
  String html = "<html>" +
  "<head></head>" +
  "<body>" +
  "  <h1>title 1</h1>" +
  "  <p>hello 1</p>" +
  "  <table>" +
  "    <tr>" +
  "      <td>hello</td>" +
  "      <td>world</td>" +
  "      <td>1</td>" +
  "    </tr>" +
  "  </table>" +
  "  <h1>title 2</h1>" +
  "  <p>hello 2</p>" +
  "  <table>" +
  "    <tr>" +
  "      <td>hello</td>" +
  "      <td>world</td>" +
  "      <td>2</td>" +
  "    </tr>" +
  "  </table>" +
  "  <h1>title 3</h1>" +
  "  <p>hello 3</p>" +
  "  <table>" +
  "    <tr>" +
  "      <td>hello</td>" +
  "      <td>world</td>" +
  "      <td>3</td>" +
  "    </tr>" +
  "  </table>" +    
  "</body>" +
  "</html>";
  Document doc = Jsoup.parse(html);
  Element firstH1 = doc.select("h1").first();
  Elements siblings = firstH1.siblingElements();
  List<Element> elementsBetween = new ArrayList<Element>();
  for (int i = 1; i < siblings.size(); i++) {
    Element sibling = siblings.get(i);
    if (! "h1".equals(sibling.tagName()))
      elementsBetween.add(sibling);
    else {
      processElementsBetween(elementsBetween);
      elementsBetween.clear();
    }
  }
  if (! elementsBetween.isEmpty())
    processElementsBetween(elementsBetween);
}

private static void processElementsBetween(
    List<Element> elementsBetween) {
  System.out.println("---");
  for (Element element : elementsBetween) {
    System.out.println(element);
  }
}