RequestOptions myOptions = new RequestOptions()
    .centerCrop();

Glide.with(ctx)
    .asBitmap()
    .apply(myOptions)
    .load(url)
    .into(bitmapView);