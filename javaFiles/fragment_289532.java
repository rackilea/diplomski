for(char page='a'; page <= 'z'; page++) {
  String urlString = String.format("http://www.medindia.net/drug-price/index.asp?alpha=%c", page);
  URL url = new URL(urlString);
  Document doc1 = Jsoup.parse(url, 0);
  Elements rows = doc1.getElementsByAttributeValue("style", "padding-left:5px;border-right:1px solid #A5A5A5;");
  for(Element row : rows){
    String htm = row.text().replace((char) 160, ' ').trim();
    if(!(htm.equals("View Price")||htm.contains("Show Details"))&& !htm.isEmpty())
    {
      System.out.println(htm.trim());
      System.out.println();
    }
  }
}