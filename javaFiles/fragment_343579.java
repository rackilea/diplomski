Element itemlist = doc.select("div.user-news.col-section.list").first();
Elements items = itemlist.getAllElements();

for(Element e : items){
    System.out.println(e.text());

}