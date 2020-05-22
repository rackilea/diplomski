public String pagination_get_link(String path, String pagnNextLink_tag) throws IOException{
    Document doc = Jsoup.parse(new File(path), "UTF-8");
    Element url = doc.getElementById(pagnNextLink_tag);
    String url_s = url.attr("href");
    // Not sure how to check if its empty, so change it to what you need.
    if(url_s == "") { 
      return "";
    }
    pagination_get_link(url_s,pagnNextLink_tag);

    return url_s;
}