String url = "http://www.spotrac.com/nba/atlanta-hawks/cap/";
Document doc = Jsoup.connect(url).get();
Elements players = doc.select("table.datatable td.player a");
for (Element player : players){
    System.out.println(player.text());
}