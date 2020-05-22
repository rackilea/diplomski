public static void main(String[] args) {
  Pattern pat = Pattern.compile("(.*)News\\:\\p{Zs}(.*)Analysis\\:\\p{Zs}(.*)", Pattern.UNICODE_CASE);
  Document doc = null;
  try {
    doc = Jsoup.connect("http://fantasynews.cbssports.com/fantasyfootball/players/updates/187741").userAgent("Mozilla").get();
  } catch (IOException e1) {
    e1.printStackTrace();
    System.exit(0);
  };

  Elements titles = doc.select("table h3");
  for (Element title : titles){
    Element td = title.parent();
    String innerTxt = td.text();
    Matcher mat = pat.matcher(innerTxt);
    if (mat.find()){
      System.out.println("titel = " + mat.group(1));
      System.out.println("news = " + mat.group(2));
      System.out.println("analysis = " + mat.group(3));
    }
  } 
}