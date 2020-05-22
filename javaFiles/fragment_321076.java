for (int i = 0; i < result.size(); i++) {
   sr = new SearchResults();
   sr.setTitle(result.get(i));
   i++;
   sr.setUser(result.get(i));
   i++;
   sr.setHex(result.get(i));
   results.add(sr);
}