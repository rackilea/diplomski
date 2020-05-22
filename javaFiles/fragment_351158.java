try {
    //change path to phantomjs binary and your script file
    String phantomJSPath = "phantomjs" + File.separator + "bin" + File.separator + "phantomjs";
    String scriptFile = "page.js";

    String searchTerm = "naruto+shippuden";
    String urlParameter = "https://www.google.com/search?site=imghp&tbm=isch&source=hp&gws_rd=cr&q="+searchTerm;

    Process process = Runtime.getRuntime().exec(phantomJSPath + " " + scriptFile + " " + urlParameter + " " + searchTerm);
    process.waitFor();

    Document doc = Jsoup.parse(new File(searchTerm + ".html"),"UTF-8"); // output.html is created by phantom.js, same path as page.js

    for (Element element : doc.select("div.rg_di.rg_bx.rg_el.ivg-i a")) {
        System.out.println(element.attr("href"));
    }
    System.out.println("Number of results: " + doc.select("div.rg_di.rg_bx.rg_el.ivg-i a").size());
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}