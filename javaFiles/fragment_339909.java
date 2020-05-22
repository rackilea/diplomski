YouTubeQuery query = new YouTubeQuery(new 
    URL("http://gdata.youtube.com/feeds/api/videos"));
query.setOrderBy(YouTubeQuery.OrderBy.VIEW_COUNT);
query.setFullTextQuery("TCS");
query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
VideoFeed videoFeed = service.query(query, VideoFeed.class);
printVideoFeed(videoFeed, true);