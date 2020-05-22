Glide.with(MainActivity.this).asFile()
            .load(url)
            .apply(new RequestOptions()
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .override(Target.SIZE_ORIGINAL))
            .into(new Target<File>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onStop() {

                }

                @Override
                public void onDestroy() {

                }

                @Override
                public void onLoadStarted(@Nullable Drawable placeholder) {

                }

                @Override
                public void onLoadFailed(@Nullable Drawable errorDrawable) {

                }

                @Override
                public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                    storeImage(resource);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {

                }

                @Override
                public void getSize(@NonNull SizeReadyCallback cb) {

                }

                @Override
                public void removeCallback(@NonNull SizeReadyCallback cb) {

                }

                @Override
                public void setRequest(@Nullable Request request) {

                }

                @Nullable
                @Override
                public Request getRequest() {
                    return null;
                }
            });