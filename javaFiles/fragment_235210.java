try {
    QueryResult result = twitter.search(new Query(args[0]));
    List<Tweet> tweets = result.getTweets();
    for (Tweet tweet : tweets) {
        System.out.println("@" + tweet.getFromUser() + " - " + tweet.getText());
    }
    System.exit(0);
} catch (TwitterException te) {
    te.printStackTrace();
    System.out.println("Failed to search tweets: " + te.getMessage());
    System.exit(-1);
}