Document document = Jsoup.parse(htmlStringOrFile);
for(Element img : document.select("img")) {
    if(img.attr("src").contains("mypic.png")) {
        System.out.println(img.attr("alt"));
    }
}