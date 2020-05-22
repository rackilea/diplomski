try {
  Document document = Jsoup.connect(url);
  Element criteria = document.getElementById("criteria");
  Element details = document.getElementById("details"); //the profile you're talking about
} catch (IOException e) {
  e.printStackTrace();
}