HashMap<Movie, Integer> map = new HashMap<Movie, Integer>();

// ArrayList<ArrayList<Movies>> listOfList = ...initialized

for (ArrayList<Movie> list : listOfList)
{
   for (Movie movie : list)
   {
      if (map.containsKey(movie))
      {
         int count = map.get(movie);
         map.put(movie, (count+1));
      }
      else
      {
         map.put(movie, 1);
      }
   }
}