ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
 ImageLoader.getInstance().init(config);
 ImageLoader.getInstance().displayImage(categoriaModelList.get(position).getImage(), holder.imgCategoria, new ImageLoadingListener() {
        @Override
        public void onLoadingStarted(String imageUri, View view) {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onLoadingCancelled(String imageUri, View view) {
            progressBar.setVisibility(View.GONE);
        }
    });