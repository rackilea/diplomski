RequestOptions myOptions = new RequestOptions()
    .fitCenter() // or centerCrop
    .override(100, 100);

 Glide.with(ctx)
     .asBitmap()
     .apply(myOptions)
     .load(url)
     .into(bitmapView);