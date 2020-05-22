for(String kvPair: kvPairs) {
   String[] kv = kvPair.split("=");
   String key = kv[0];
   String value = kv[1];

   // Now do with key whatever you want with key and value...
   if(key.equals("specialkey")) {
       // Do something with value if the key is "specialvalue"...
   }
}