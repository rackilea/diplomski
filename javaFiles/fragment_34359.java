Document doc = Jsoup.connect("http://www.ferotech.com/Services/default.aspx").get();

Element content = doc.select("div.smallHd_contentTd").first();

String header = content.select("h2").first().text();

System.out.println(header);

for (Element pTag : content.select("p")) {
    System.out.println(pTag.text());
}