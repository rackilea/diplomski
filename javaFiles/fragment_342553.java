private Ticker ticker = Mockito.mock(Ticker.class);

@SuppressWarnings({"unchecked"})
private RemovalListener<String, String> removalListener = Mockito.mock(RemovalListener.class);

private Cache<String, String> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .removalListener(removalListener)
            .ticker(ticker)
            .build();