@Test
public void testEntrySetAccessDoesNotCountAsAccess() {
    //write
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(0));
    cache.put("foo", "bar");

    //read
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(4));
    cache.asMap().entrySet().iterator().next().getValue();
    cache.asMap().entrySet().iterator().next().getKey();

    //maintenance
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(6));
    cache.cleanUp();

    verify(removalListener).onRemoval(Mockito.<RemovalNotification<String,String>>any());
}