@Test
public void testKeySetAccessDoesNotCountAsAccess() {
    //write
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(0));
    cache.put("foo", "bar");

    //read
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(4));
    cache.asMap().keySet().iterator().next();

    //maintenance
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(6));
    cache.cleanUp();

    verify(removalListener).onRemoval(Mockito.<RemovalNotification<String,String>>any());
}