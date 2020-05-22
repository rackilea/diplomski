mImageLoader = new ImageLoader(Volley.newRequestQueue(this),
            new ImageLoader.ImageCache() {
        private final LruCache<String, Bitmap>
                cache = new LruCache<String, Bitmap>(20);

        @Override
        public Bitmap getBitmap(String url) {
            return cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
        }
    });