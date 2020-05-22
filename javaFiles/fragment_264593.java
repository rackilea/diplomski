Iterator<?> keys = jsonObj.keys();

     while( keys.hasNext() ){
          String key = (String)keys.next();
          System.out.print("key - value"+ key +   jsonObj.getString(key)); 
    }