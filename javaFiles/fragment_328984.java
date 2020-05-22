class CacheTest {
  private String test = "testString";
  private WeakReference<String> cache = new WeakReference<String>(test);

  public void evictCache(){
    test = null; // this removes "testString" from the pool because there is no strong reference; there is a weak reference only. 
    System.gc(); //suggestion to JVM to trigger GC 
  }
}