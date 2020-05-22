Document doc = Jsoup.connect("http://stackoverflow.com/questions/14541740/java-program-to-download-images-from-a-website-and-display-the-file-sizes").get();

Elements imgElements = doc.select("img[src]");
Map<String, String> fileSizeMap = new HashMap<String, String>();

for(Element imgElement : imgElements){
    String imgUrlString = imgElement.attr("abs:src");
    URL imgURL = new URL(imgUrlString);
    HttpURLConnection httpConnection = (HttpURLConnection) imgURL.openConnection();
    String contentLengthString = httpConnection.getHeaderField("Content-Length");
    if(contentLengthString == null)
        contentLengthString = "Unknown";

    fileSizeMap.put(imgUrlString, contentLengthString);
}

for(Map.Entry<String, String> mapEntry : fileSizeMap.entrySet()){
    String imgFileName = mapEntry.getKey();
    System.out.println(imgFileName + " ---> " + mapEntry.getValue() + " bytes");
}