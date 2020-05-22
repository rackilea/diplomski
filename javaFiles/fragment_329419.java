while (true) {
    tweet = tweets.get(tweetIndex);
    user = tweet.new User();
    entity = tweet.new Entities();

    userMentions = entity.getUserMentions();
    hashtags = entity.getHashtags();

    if (tweet.getText() == null) {
        break;
    }