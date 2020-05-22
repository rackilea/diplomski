Document doc = Jsoup.parse("your html")
String selectedVal = null;
Elements options = doc.getElementsByAttributeValue("name", "Category").get(0).children();
for (Element option : options) {
    if (option.hasAttr("selected")) {
        selectedVal = option.val();
    }
}