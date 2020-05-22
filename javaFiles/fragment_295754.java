private void setMovieDetails(@Nullable Bitmap poster, @Nullable Bitmap fanart, @Nullable String title, int id) { 
    MovieDetails details;
    boolean isAlreadyThere = true;
    try {
        details = ca.movieList.get(id);
    } catch (IndexOutOfBoundsException e) {
        isAlreadyThere = false;
        // If we come with a bad ID we crash. No fun.
        details = makeGenericMovieDetails();
    }
    if (poster != null)
        details.imageViewPoster = poster;
    if (fanart != null)
        details.imageViewFanart = fanart;
    if (title != null)
        details.Title = title;
    ca.movieList.set(id, details);

    if (isAlreadyThere) {
        ca.notifyItemChanged(id);
    } else {
        ca.notifyItemInserted(id);
    }
}