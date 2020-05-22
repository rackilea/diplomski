String br = "<html><source>foo bar bar</source></html>";
Document doc = Jsoup.parse(br, "", Parser.xmlParser());

for (Element sentence : doc.getElementsByTag("source")) {
    System.out.println(sentence.text());
}
