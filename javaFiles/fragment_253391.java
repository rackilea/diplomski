AppWidgetTarget awt = new AppWidgetTarget(context, R.id.img_dog, remoteViews, appWidgetIds) {
    @Override
    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
        super.onResourceReady(resource, transition);
    }
};

RequestOptions options = new RequestOptions().
        override(300, 300).placeholder(R.drawable.placeholder_img).error(R.drawable.error_img)


Glide.with(context.getApplicationContext())
        .asBitmap()
        .load(imageUrl)
        .apply(options)
        .into(awt);