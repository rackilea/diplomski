String feedUrl = "http://gdata.youtube.com/feeds/api/standardfeeds/most_viewed";

    YouTubeService service = new YouTubeService("youtube", "DEVELOPER_KEY_HERE");
    service.setUserCredentials("LOGIN@gmail.com", "YOUR_PASSWORD_HERE");
    VideoFeed videoFeed = service.getFeed(new URL(feedUrl), VideoFeed.class);
    printVideoFeed(videoFeed, true);