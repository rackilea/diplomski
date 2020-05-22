public static void contributeAssetDispatcher(
        MappedConfiguration<String, AssetRequestHandler> config,
        ResourceStreamer streamer)
{
   config.add("staticfile", new StaticFileAssetRequestHandler(streamer));
}

public void contributeAssetSource(
        MappedConfiguration<String, AssetFactory> config)
{
    config.add("staticfile", new StaticFileAssetFactory());
}