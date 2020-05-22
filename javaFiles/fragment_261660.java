@RunWith(PowerMockRunner.class)
@PrepareForTest(Cache.class)
public class EhCacheBaseTest {
    private static final String CACHE_NAME = "testCache";
    private CacheManager cacheManager;
    private Cache cache;
    private EhCacheBase<String, Object> ehCacheBase;

    @Before
    public void init() {
        // You can statically import mock method, but left it this way 
        // for clarity
        cacheManager = PowerMockito.mock(CacheManager.class);
        cache = PowerMockito.mock(Cache.class);
        ehCacheBase = new EhCacheBase<String, Object>(CACHE_NAME);
        EhCacheBase.setCacheManager(cacheManager);
    }

    @Test
    public void shouldRetrieveCacheAndPutOneValueInIt() {
        //given
        Object o = new Object();
        when(cacheManager.getCache(CACHE_NAME)).thenReturn(cache);

        //when
        ehCacheBase.cache("KEY", o);

        //then
        verify(cacheManager, times(1)).getCache(CACHE_NAME);
        verify(cache, times(1)).put(any(Element.class));
    }
}