HashMap<String,String> internedStrings = new HashMap<String,String>();

syncrhonized String returnUniqueString(String str) {
   String alreadyCached = internedStrings.get(str);
   if (alreadyCached == null) {
      internedStrings.put(str, str);
      alreadyCached = str;
   }
   return alreadyCached;
}