@Override
public void onBindViewHolder(DataHolder holder, int position) {
    ImageLoaderConfiguration config;
    config = new ImageLoaderConfiguration.Builder(mContext).build();
    ImageLoader.getInstance().init(config);
    imageLoader = ImageLoader.getInstance();

    DisplayImageOptions options = new DisplayImageOptions.Builder()
    .showImageForEmptyUri(R.drawable.ic_error_black_48dp) // displays this image not found
    .showImageOnFail(R.drawable.ic_error_black_48dp) // Displays this on failure
    .showImageOnLoading(R.drawable.white) // Displays while loading
    .cacheInMemory(false)
    .cacheOnDisk(true)
    .build();

    imageLoader.displayImage(list.get(position), holder.imageView, options);    
    // We are feeding the urls here. 
}