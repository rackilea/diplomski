try {
    Process process = Runtime.getRuntime().exec("bin\\phantomjs page.js"); //change path to phantomjs binary and your script file
    process.waitFor();

    Document doc = Jsoup.parse(new File("output.html"),"UTF-8"); // output.html is created by phantom.js, same path as page.js

    for (Element element : doc.select("div.rg_di.rg_bx.rg_el.ivg-i a")) {
        System.out.println(element.attr("href"));
    }
    System.out.println("Number of results: " + doc.select("div.rg_di.rg_bx.rg_el.ivg-i a").size());
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}