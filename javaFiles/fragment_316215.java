// can only grab first 100 results
String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
String url = "https://www.google.com/search?site=imghp&tbm=isch&source=hp&q=kittens&gws_rd=cr";

List<String> resultUrls = new ArrayList<String>();

try {
    Document doc = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();

    Elements elements = doc.select("div.rg_meta");

    JSONObject jsonObject;
    for (Element element : elements) {
        if (element.childNodeSize() > 0) {
            jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString());
            resultUrls.add((String) jsonObject.get("ou"));
        }
    }

    System.out.println("number of results: " + resultUrls.size());

    for (String imageUrl : resultUrls) {
        System.out.println(imageUrl);
    }

} catch (IOException | ParseException e) {
    e.printStackTrace();
}