do {
    final long startTime = System.nanoTime();
    result = twitter.search(query);
    statuses = result.getTweets();
    for (Status status : statuses) {
        tweet = new Tweet(status);
        userProfile = new UserProfile(status.getUser());

        imageDownloader.getMedia(tweet.mediaEntities);
        imageDownloader.getProfilePhoto(userProfile.ProfileImageUrl);

        System.out.println(tweet);
        System.out.println(userProfile);
    }
    final long duration = System.nanoTime() - startTime;
    if ((5500 - duration / 1000000) > 0) {
        logger.info("Sleep for " + (6000 - duration / 1000000) + " miliseconds");
        Thread.sleep((5500 - duration / 1000000));
    }
} while ((query = result.nextQuery()) != null);