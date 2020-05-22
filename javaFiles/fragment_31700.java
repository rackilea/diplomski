Document doc = Jsoup.parse(html,"");

Element tableEl = doc.select("table#ctl00_Body_gvResult").first();
Elements rowEls = tableEl.select("tr");

for (Element rowEl : rowEls){
    Elements tds = rowEl.select("td");
    if (tds.isEmpty() || tds.size()<4){
        continue;
    }
    //title
    String title = tds.get(2).ownText();

    //grade
    String grade = tds.get(3).ownText();

    System.out.println("title: "+title+", grade: "+grade);
}