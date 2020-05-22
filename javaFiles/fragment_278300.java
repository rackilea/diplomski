Document doc = Jsoup.parse(input, "UTF-8", "http://www.mhpa.co.uk/notice-to-mariners/");

Element content = doc.getElementById("content");
Elements divs = content.getElementsByTag("div");
int ntmAmount = 0;
for (Element div : divs) {
  if (div.hasClass("news_main"))
    ntmAmount++;
}