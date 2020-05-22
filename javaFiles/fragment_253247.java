protected void onActivityResult(int RC, int RQC, Intent I) {
        super.onActivityResult(RC, RQC, I);
        if (RC == 1 && RQC == RESULT_OK && I != null && I.getData() != null) {
            Uri uri = I.getData();
            RequestOptions options = new RequestOptions()
                    .format(DecodeFormat.PREFER_RGB_565)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background);

            Glide.with(this)
                    .setDefaultRequestOptions(options)
                    .load(uri)
                    .centerInside()
                    .into(new CustomTarget<Drawable>(1000, 500) {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            imageView1.setImageDrawable(resource);
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {

                        }
                    });
        }