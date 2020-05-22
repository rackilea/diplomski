@Test
public void testValuesAccessDoesNotCountAsAccess() {
    //write
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(0));
    cache.put("foo", "bar");

    //read
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(4));
    cache.asMap().values().iterator().next();

    //maintenance
    when(ticker.read()).thenReturn(TimeUnit.SECONDS.toNanos(6));
    cache.cleanUp();

    verify(removalListener).onRemoval(Mockito.<RemovalNotification<String,String>>any());
}