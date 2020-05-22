for(Map.Entry<String, String> entry : hashMap.entrySet())
   {
     String key = entry.getKey();
     String value = entry.getValue();

     if(searchString.equals(key) || searchString.equals(value))
       {
          String keyAndValue = key + value; // this is what you want
       }    
   }