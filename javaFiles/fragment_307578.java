//If you use an URL you haven't to especify base URL
    Document doc=Jsoup.connect("http://superior.edu.pk/presentation/user/Default.aspx").get();
    //If you use a file or a String you have. Base URL is http://superior.edu.pk/presentation/user/ of course  
    //Document doc = Jsoup.parse(Main.class.getResourceAsStream("page.htm"), "utf-8", "http://superior.edu.pk/presentation/user/");

    //Only as an example. You can fetch any anchor as wou wish.
    Elements links = doc.select("div.footerMaterial > a");
    for (Element link : links){
        String attr = link.absUrl("href");
        System.out.println(attr);
    }