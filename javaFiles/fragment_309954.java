for(String key : hashMap.keySet())
   {
     String value = hashMap.get(key);

     if(searchString.equals(value))
       {
          String keyAndValue = key + value; // this is what you want
       }    
   }