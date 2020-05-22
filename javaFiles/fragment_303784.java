Elements allLis = doc.select("#the_main_form > li ");
for (Element li : allLis) {
    Element a = li.select("div:eq(1) > h2 > a");
    String href = a.attr("href");
    String text = a.text();
}