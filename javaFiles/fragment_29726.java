public class MyCacheEventListenerFactory extends CacheEventListenerFactory {
  @Override
  public CacheEventListener createCacheEventListener(Properties properties) {
    return new CacheListener();
  } 
}