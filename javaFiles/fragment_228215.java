GetFeedsNetworkRequest request = new GetFeedsNetworkRequest(feedURLs);
List<FeedResponse> feedResponses = request.performRequest();
for (FeedResponse feedResponse : feedReponses) {
    // gather fields you need to construct RssFeed
    String channelTitle = feedResponse.channelTitle;
    List<RssItem> items = new ArrayList<>();
    for (ItemResponse itemResponse : feedResponse.channelItems) {
        // gather fields you need to construct RssItem
        String itemDescription = itemResponse.itemDescription;
        items.add(new RssItem(..., itemDescription, ...));
    }
    feeds.add(new RssFeed(..., channelTitle, ..., items, ...);
}