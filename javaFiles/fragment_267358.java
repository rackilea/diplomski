RequestOptions requestOptions = new RequestOptions();
    requestOptions.dontAnimate();
    requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    requestOptions.timeout(10000);
    requestOptions.override(2000,2000);
    requestOptions.fitCenter();
    requestOptions.format(DecodeFormat.PREFER_RGB_565);
mainFragment.getmGlide().with(mainFragment.getMcurrentContext())
 .asBitmap()
 .load(rogImage)
 .apply(requestOptions)
 .listener(new RequestListener<Drawable>() {
        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            return false;
        }

        @Override
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            ProgressBarHandler.unloadProgressScreen(getActivity());
            return false;
        }
    })
    .into(new SimpleTarget<Drawable>() {
        @Override
        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
            tempImageView.setImageDrawable(resource)
        }

    });