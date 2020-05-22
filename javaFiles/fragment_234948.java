File image = new File(path);

    Picasso picasso = new Picasso.Builder(context)
            .listener(new Picasso.Listener() {
        @Override public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
            Logger.logError("ERROR Download image: ", exception, context);
        }
    }).build();

    picasso
            .load(image)
            .fit()
            .centerInside()
            .placeholder(R.drawable.progress_animation)
            .error(R.drawable.image_error_404)
            .into(iv, new Callback() {
                @Override public void onSuccess() {
                    Logger.logGeneral("image downloaded");
                }

                @Override public void onError() {
                    Logger.logGeneral("onError image downloaded");
                }
            });