String rssUrl = "";    
    try{
          Document doc = Jsoup.connect(url).get();

          Elements links = doc.select("link[type=application/rss+xml]");
          if (links.size() > 0) {
              rssUrl = links.get(0).attr("abs:href").toString();
          }
          else if(rssURLNews(url) != ""){

            rssUrl = rssURLNews(url);
          }
          else if(rssURLrss(url) != "")
              rssUrl = rssURLrss(url);
          else{
                rssUrl = "No URL found";
            }
        }
        catch (IOException ex) {
          Logger.getLogger(RSSReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rssUrl;

}