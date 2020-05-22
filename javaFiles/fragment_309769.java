public class Bundle extends HashMap<String,Object>{

   public void putString(String key, String str){
      put(key, str);
   }

   public String getString(String key){
      Object o = get(key);
      if(o!=null && o instanceof String)
         return (String) o;
      return null;
   }

   public void putInteger(String key, int anInt){
      put(key, new Integer(anInt));
   }

   public Integer getInteger(String key){
      Object o = get(key);
      if(o!=null && o instanceof Integer)
         return (Integer) o;
      return null;
   }

   ...

}