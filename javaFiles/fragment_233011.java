values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, newsReport.getTitle());
values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CONTENT, newsReport.getContent());
values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CHANNEL, newsReport.getNewsChannel());
values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_IMAGE, newsReport.getPic());
values.put(NewsFeedProvider.newsTitle, newsReport.getTitle());
values.put(NewsFeedProvider.newsContent, newsReport.getContent());
values.put(NewsFeedProvider.newsChannel, newsReport.getNewsChannel());
values.put(NewsFeedProvider.newsImage, newsReport.getPic());