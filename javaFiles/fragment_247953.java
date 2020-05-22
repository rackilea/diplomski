public FeedRecyclerAdapter(Context context, List<Feed> feedItems, ImageLoader feedItemImageLoader, List<Feed> adItems) {
    this.context = context;
    this.feedItems = feedItems;
    this.feedItemImageLoader = feedItemImageLoader;
    feedItems.addAll(adItems);
}