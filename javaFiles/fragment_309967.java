RequestOptions myOptions = new RequestOptions()
    .override(100, 100);

Glide.with(fragment)
    .asBitmap()
    .apply(myOptions)
    .load(url)
    .into(bitmapView);