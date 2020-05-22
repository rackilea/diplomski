String htmlString= "<img src='file:///android_asset/img/pj1.jpg' />";
    Document doc=Jsoup.parse(htmlString);
    Elements imgs=doc.select("[src]");
    for(Element img : imgs){
        File f=new File(img.attr("src"));
        System.out.println(f.getName());
    }