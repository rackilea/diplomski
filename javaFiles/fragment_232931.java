package foo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class ExampleLazyLoad {

  private volatile ConcurrentMap<String, String> myExpensiveCache = null;


  public ConcurrentMap<String, String> getMyExpensiveMap() {
    if (myExpensiveCache == null) {
      synchronized (this) {
        if (myExpensiveCache == null) {
          final ConcurrentMap<String, String> newCache = new ConcurrentHashMap<String, String>();
          // init the map
          myExpensiveCache = newCache;
        } // if
      } // synchronized
    } // if
    return myExpensiveCache;
  }

}