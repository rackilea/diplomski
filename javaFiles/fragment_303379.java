public Map<String, List<Recommendation>> localStoreOfMovies() {

  // Call an API based on actor names, or maybe you have local list
  Map<String, List<Recommendation>> localStore = 
         new HashMap<String, List<Recommendation>>();

  List<Recommendation> movies = new List<Recommendation>();
  // Add robert de niro movies to movies list 
  localStore.put("robertdeniro",  movies);

  return localStore;
 }