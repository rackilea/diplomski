//If you want the whole page
String url = "http://www.yourwebsite.com";
Document doc = Jsoup.connect(url).get();
System.out.println(doc.text());

//If you want some specific part of the page
Elements elems = doc.select("query");

for (Element element : elems) {
    System.out.println(element.text() + "\n");
    System.out.println(element.ownText() + "\n\n");
}