Document doc = Jsoup.connect("http://tvrehberi.hurriyet.com.tr/program-detay/308271/deli-deli-olma").get();

List<String> saatItem = new ArrayList<String>();

for( Element element : doc.select("div[class=content clear]"))
{
    saatItem.add(element.text());
}