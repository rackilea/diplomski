public GenreManager(Collection<Genre> genres){
  this.genres = new TreeSet<>(); //the generic type is inferred from this.genres

  for( Genre element : genres ) {
    //If the element didn't exist in the set add() will return true, false if it existed  
    boolean nonDuplicate = this.genres.add( element );

    //handle the duplicate element here
  }
}