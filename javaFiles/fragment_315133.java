Document doc = Jsoup.connect("http://test.com").get();
List<String> criterias = Arrays.asList("div.foo", "span.bar");
Document tmpDoc = doc;
for (String criteria: criterias) {
    if (tmpDoc != null)
        tmpDoc = tmpDoc.select(criteria);
}
// now you have traversed the whole criterias just get the text
String companyName = tmpDoc.text();