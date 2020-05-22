for (String genreName : submittedTextGenres) {
   Genre genre = genreDAO.findByName(genre);
   if (genre == null) { //a new genre
      genre = new Genre(genreName);
   }

   audioTrack.addGenre(genre);
}