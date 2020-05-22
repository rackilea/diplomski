Document doc = Jsoup.connect("http://www.bezaat.com/ksa/jeddah/cars/all/1?so=77").get();
for (Element adDiv : doc.select("div.category-listing-normal-ad")){

  Element priceDiv = adDiv.select("div.rightFloat.price").first();
  Element linkA = adDiv.select("a.more-details").first();

  System.out.println(priceDiv.text() + " " + linkA.absUrl("href"));