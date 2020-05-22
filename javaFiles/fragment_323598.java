// ..

TmdbMovies movies = new TmdbApi("###########").getMovies();
MovieDb movie_name;
try{
    movie_name = movies.getMovie(movieID, "en");
}catch(Throwable e){
    System.err.println("Erreur getting movie #"+movieID);
    return;
}

// ...