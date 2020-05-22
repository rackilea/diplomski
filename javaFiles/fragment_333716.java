String website = "http://www.svensktnaringsliv.se/english/publications/?start=" +maxPage;
Document docOne = Jsoup.connect(website).get();
Elements els = docOne.select("a.subHover");
for (Element el : els ){
  System.out.println(el);
}