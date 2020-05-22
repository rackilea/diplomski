Document doc = Jsoup.parse(htmlString);
Element msoNormal = doc.getElementsByClass("MsoNormal").first();
if(msoNormal!=null){
  Pattern p = Pattern.compile("[0-9]+,[0-9]+");
  Matcher m = pattern.matcher(msoNormal.text());
  if(matcher.find())
    System.out.println(m.get());
}