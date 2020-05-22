String html = "<p>lorem ipsum</p><pre>Hello World</pre><p>dolor sit amet</p>";
Document document = Jsoup.parse(html);
Elements pres = document.select("pre");

for (Element pre : pres) {
    System.out.println(pre.text());
}