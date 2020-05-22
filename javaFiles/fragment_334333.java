for (String genreName : submittedTextGenres) {
   Genre genre = genreDAO.findByName(genre);
   if (genre == null) { //a new genre
      try {
         genre = genreDAO.insertGenre(genre); //a transaction
      } catch (GenreExistsException) {
         genre = genreDAO.findByName(genre); //a separate transaction
      }
   }

   audioTrack.addGenre(genre);
}