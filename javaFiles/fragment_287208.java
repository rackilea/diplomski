Map<Integer, Movie> movies = new HashMap<Integer, Movie>();

// for each movie
movies.put(movie.getNumber(), movie);

...
// retrieving the selected movie
Movie selectedMovie = movies.get(movieNumber);

if (selectedMovie == null)
  System.out.println("Invalid movie number!");