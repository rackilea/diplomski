Movie searchMovie = null;
for (int i = 0; i < movies.length; i++) {
   if (input.getText().equals(movies[i].title)) {
      searchMovie = movies[i];
      break;
   }
}

if (searchMovie == null) {
   output.setText("THAT MOVIE IS NOT AVAILABLE");
} else {
   output.setText(searchMovie.toString());
}