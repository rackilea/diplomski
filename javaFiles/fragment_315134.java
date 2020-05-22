Document doc = Jsoup.connect("http://test.com").get();
List<String> criterias = Arrays.asList("div.foo", "span.bar");
Method select = doc.getClass().getMethod("select", String.class);
Document tmpDoc = doc;
for (String criteria: criterias) {
    if (tmpDoc != null)
        tmpDoc = (Document)select.invoke(tmpDoc, new Object[] {criteria});
}
// now you have traversed the whole criterias just get the text
String companyName = tmpDoc.text();