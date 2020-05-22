String searchTerm = "naruto shippuden";
String searchUrl = "https://www.google.com/search?site=imghp&tbm=isch&source=hp&biw=1920&bih=955&q=" + searchTerm.replace(" ", "+") + "&gws_rd=cr";

try {
    Document doc = Jsoup.connect(searchUrl)
            .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
            .referrer("https://www.google.com/").get();

    JSONObject obj;

    for (Element result : doc.select("div.rg_meta")) {

        // div.rg_meta contains a JSON object, which also holds the image url
        obj = (JSONObject) new JSONParser().parse(result.text());

        String imageUrl = (String) obj.get("ou");

        // just printing out the url to demonstate the approach
        System.out.println("imageUrl: " + imageUrl);    
    } 

} catch (IOException e1) {
    e1.printStackTrace();
}catch (ParseException e) {
    e.printStackTrace();
}