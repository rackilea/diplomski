Cache<String, String> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(100, TimeUnit.SECONDS)
            .removalListener(new RemovalListener<Object, Object>() {
                public void onRemoval(RemovalNotification<Object, Object> objectObjectRemovalNotification) {
                    //do something
                }
            })
            .build();