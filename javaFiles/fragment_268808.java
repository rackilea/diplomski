File cacheDir = new File(this.getCacheDir(), "directory_name");
if (!cacheDir.exists())
    cacheDir.mkdir();

ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
            YourActivity.this).threadPoolSize(5)
            .threadPriority(Thread.MIN_PRIORITY + 3)
            .denyCacheImageMultipleSizesInMemory()
            // .memoryCache(new UsingFreqLimitedMemoryCache(2000000)) // You
            // can pass your own memory cache implementation
            .memoryCacheSize(1048576 * 10)
            // 1MB=1048576 *declare 20 or more size if images are more than
            // 200
            .discCache(new UnlimitedDiscCache(cacheDir))
            // You can pass your own disc cache implementation
            // .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
            .build();

imageLoader = ImageLoader.getInstance();
imageLoader.init(config);
imageLoader.clearMemoryCache();
imageLoader.clearDiscCache();

options = new DisplayImageOptions.Builder()
            .showStubImage(R.drawable.avatar)
            .showImageForEmptyUri(R.drawable.home_shortcut).cacheInMemory()
            .cacheOnDisc().build();