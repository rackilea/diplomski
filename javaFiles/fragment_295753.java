private MovieDetails makeGenericMovieDetails() {
    MovieDetails moviedetails = new MovieDetails();
    // The size of the list, but add one.
    moviedetails.title= "Name" + (adapter.getSize() + 1);

    Bitmap bit = resizeBitmap(getResources(), R.drawable.poster_example, 640, 955);
    moviedetails.imageViewPoster = bit;

    Bitmap bit2 = resizeBitmap(getResources(), R.drawable.fanart_example, 800, 450);
   moviedetails.imageViewFanart = bit2; 
return moviedetails;
}