public static Movie2[] sortTitles(Movie2[] movies, int asc) {
    if (asc == 2) {
        asc = 0;
    }

    for (int index = 1; index < movies.length; index += 1) {
        int other = index - 1;
        Movie2 movie = movies[index];
        int first = (int) movies[index].getTitle().toLowerCase().charAt(0);
        int second = (int) movies[other].getTitle().toLowerCase().charAt(0);

        while (other >= 0 && (((first > second) ? 1 : 0) == asc)) {
            movies[other + 1] = movies[other];
            other = other - 1;
            if (other >= 0) {
                second = (int) movies[other].getTitle().toLowerCase().charAt(0);
            }
        }
        movies[other + 1] = movie;
    }

    return movies;
}