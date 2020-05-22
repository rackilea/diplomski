import java.util.concurrent.ConcurrentHashMap;

public class CacheListener implements CacheEventListener  {
   //prob bad practice to use a global static here - but its just for demo purposes
   public static ConcurrentHashMap myMap = new ConcurrentHashMap();

   @Override
   public void notifyElementPut(Ehcache ehcache, Element element) throws CacheException {
     //we can remove it since the put happens after a method return
     myMap.remove(element.getKey());
   }

   @Override
   public void notifyElementExpired(Ehcache ehcache, Element element) {
    //expired item, we should store this
    myMap.put(element.getKey(), element.getValue());
    }
 //....
}