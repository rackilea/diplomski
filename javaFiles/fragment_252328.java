RSSReader reader = new RSSReader();
  RSSFeed feed = reader.load(feedUrl);
  List<RSSItem> list = feed.getItems();
  for (RSSItem i: list) 
  {
    i.getTitle();//title content
    i.getDescription();//description content
    i.getLink();//link
  }