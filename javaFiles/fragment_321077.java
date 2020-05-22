for (int i = 0; i < result.size(); i++) {
   sr = new SearchResults();
   sr.setTitle(result.get(i));

   i++;
   if (i == result.size()) {
      sr.setUser("dummy");
   }
   else {
      sr.setUser(result.get(i));
   }

   i++;
   if (i == result.size()) {
      sr.setHex("#000000");
   }
   else {
      sr.setHex(result.get(i));
   }

   results.add(sr);
}