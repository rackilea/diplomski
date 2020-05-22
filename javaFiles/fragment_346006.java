Document doc = Jsoup.connect("http://example.com/").get();

Elements pngs = doc.select("img[src$=.png]");

//After this just iterate over selected elements 
//and extract values you are interested in like 

for (Element png : pngs)
    System.out.println(png.attr("src"));