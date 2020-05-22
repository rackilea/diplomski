Uri uri = Uri.parse("http://upload.wikimedia.org/wikipedia/commons/e/e8/Svg_example3.svg");
requestBuilder
    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
    // SVG cannot be serialized so it's not worth to cache it
    .load(uri)
    .into(mImageView);