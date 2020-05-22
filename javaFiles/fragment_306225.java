Picasso.with(getContext()).load(url).into(new Target() {
    @Override public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        Drawable d = new BitmapDrawable(getResources(),bitmap);
        imageView.setBackground(d);
    }
    @Override public void onBitmapFailed(Drawable errorDrawable) { }
    @Override public void onPrepareLoad(Drawable placeHolderDrawable) { }
});