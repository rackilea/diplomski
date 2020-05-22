Document document = Jsoup.parse(new File("/persons.xml"), "UTF-8");

Element person2 = document.select("person[id=2]").first();
System.out.println(person2.select("name").text());

Elements streets = document.select("street");
for (Element street : streets) {
    System.out.println(street.text());
}