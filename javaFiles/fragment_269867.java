Document document = Jsoup.connect("https://www.aliexpress.com/category/200214036/women-watches.html?spm=2114.search0103.3.7.765d221bi3J3Io&site=glo&g=y").get();
    Elements titleElement = document.select("div.item > div.img > div.pic > a.picRind > img");
    //print img elements to see if source attribute is "src" or "image-src"
    titleElement.stream().forEach(System.out::println);
    //String essay = essayElement.text();
    int i = 0;
    String linkss[] = new String[titleElement.size()];
    for(Element el : titleElement){
        //check if src value is empty, which is true if the src attr does not exist
        if(!el.attr("abs:src").isEmpty()){
            linkss[i] = el.attr("abs:src");
        }
        else{
            linkss[i] = el.attr("abs:image-src");
        }
        //System.out.println(linkss[i]);
        i++;
    }