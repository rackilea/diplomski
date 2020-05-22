private LoadingCache<Integer, Image> cache = CacheBuilder.newBuilder().
        build(new CacheLoader<Integer, Image>() {
            @Override
            public Image load(Integer key) throws Exception {
                return httpGetImageExpensively(key);
            }
        });

public Image getPicture(int pictureId) {
   return cache.getUnchecked(pictureId); // blocks until image is in cache
}