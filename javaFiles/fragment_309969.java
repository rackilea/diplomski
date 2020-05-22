RequestOptions myOptions = new RequestOptions()
        .fitCenter();

    Glide.with(ctx)
        .asBitmap()
        .apply(myOptions)
        .load(url)
        .into(bitmapView);