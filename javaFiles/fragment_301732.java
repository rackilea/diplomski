String html = "<h6 class='uiStreamMessage' data-ft=''><span class='messageBody' data-ft=''>Twisted<a href='http://'><span>http://</span><span class='word_break'></span>www.tb.net/</a> Balloons</span></h6>";
 Document doc = Jsoup.parse(html);
 Elements elements = doc.select("h6.uiStreamMessage > span.messageBody");
 for (Element e : elements) {
      System.out.println("All text:" + e.text());
      System.out.println("Only messageBody text:" + e.ownText());
}