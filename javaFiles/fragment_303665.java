private static final class TestKey implements Serializable {

    boolean equals;
    int hash;

    TestKey( boolean equals, int hash ){
        this.equals = equals;
        this.hash = hash;
    }

    @Override
    public boolean equals( Object other ){ return equals; }

    @Override
    public int hashCode(){ return hash; }
}




public void testIdentity() throws Exception {

    // A simple wrapper around EHCache which does the configuration
    // and provides a map like interface
    CacheEHCache<TestKey,String> cache = CacheEHCache.instance(
            new File( "/tmp/ehcache" ), "testcache", 10 );

    // May contain content from last run
    cache.clear();

    // equals and hash matches
    TestKey k11 = new TestKey( true, 1 );

    cache.put( k11, "Test11" );

    assertEquals( cache.size(), 1 );
    assertTrue( cache.containsKey( k11 ) );

    cache.remove( k11 );
    assertEquals( cache.size(), 0 );

    // doesn't equal but hash matches
    TestKey k21 = new TestKey( false, 1 );

    cache.put( k21, "Test21" );
    assertEquals( cache.size(), 1 );
    assertFalse( cache.containsKey( k21 ) );

    // This is interesting: Clear needs to find the objects to clear
    // So we must patch it.
    k21.equals = true; 
    cache.clear();
    assertEquals( cache.size(), 0 );

    // equals but hash missmatches
    TestKey k31 = new TestKey( true, 1 );
    TestKey k32 = new TestKey( true, 2 );
    cache.put( k31, "Test21" );
    assertEquals( cache.size(), 1 );
    assertTrue( cache.containsKey( k31 ) );
    assertFalse( cache.containsKey( k32 ) );
    cache.clear();
}