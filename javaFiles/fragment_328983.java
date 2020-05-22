class CacheTest {
  private String test = "testString";
  private String another = "testString";

  public void evictCache(){
    test = null; // this still doesn't remove "testString" from the string pool because there is another strong reference (another) to it.
    System.gc(); //suggestion to JVM to trigger GC 
  }
}