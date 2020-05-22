builder.setBolt("status", new MemoryStatusUpdater()).
    .localOrShuffleGrouping("fetch", Constants.StatusStreamName)
    .localOrShuffleGrouping("sitemap", Constants.StatusStreamName)
    .localOrShuffleGrouping("jsoup", Constants.StatusStreamName)
    .localOrShuffleGrouping("tika", Constants.StatusStreamName)
    .localOrShuffleGrouping("indexer", Constants.StatusStreamName);