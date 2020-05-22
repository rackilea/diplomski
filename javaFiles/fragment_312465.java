String html = //HTML posted above

Document doc = Jsoup.parse(html);

Elements elements = doc.select("[style]");
for (Element e : elements) {
   System.out.println(e.hashCode());
}