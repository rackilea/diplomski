public String get_main_url(int num) {
        int num = 7453201;
        String jpgurl  = null;
        try {
            downloadImage(num);
        } catch (Exception e) {
            e.printStackTrace();
            num=0;//set the default value for which img exists
            downloadImage(num);//call downloadImage with default num
        }
    }

private String downloadImage(int num) {
     String url = "https://www.zigbang.com/items1/"+num; 
     System.out.println(url);
     Document doc = Jsoup.connect(url).get();
     jpgurl = doc.select("img[src$=.jpg?h=800&q=60]").get(0).absUrl("src");
     System.out.println(i + "="+jpgurl);
}