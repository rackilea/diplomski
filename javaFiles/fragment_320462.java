interface FeedCounter {
    void count(int... newFeeds);
}

static void getFeed(FeedCounter feedCounter) {
    feedCounter.count(12, 13);
}