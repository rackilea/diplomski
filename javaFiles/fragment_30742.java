import java.util.*;

public class HashMapExample     
{
    public static void main (String[] args)
    {
       Map<String,Integer> map = new HashMap<>();
       map.put("one", 1);
       map.put("two", 2);
       map.put("three", 3);

      //how to traverse a map with Iterator 
      Iterator<String> keySetIterator = map.keySet().iterator();

      while(keySetIterator.hasNext()){
     String key = keySetIterator.next();
     System.out.println("key: " + key + " value: " + map.get(key));
       }
    }
}