public boolean containsAKeyword(String myString, List<String> keywords){
   for(String keyword : keywords){
      if(myString.contains(keyword)){
         return true;
      }
   }
   return false; // Never found match.
}