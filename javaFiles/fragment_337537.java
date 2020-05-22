ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this)
    .enableLogging()
    .memoryCacheSize(41943040)
    .discCacheSize(104857600)
    .threadPoolSize(10)
    .build();

imageLoader = ImageLoader.getInstance();
imageLoader.init(imageLoaderConfiguration);