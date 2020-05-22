public void addGrade(Movie movie, Grade grade) {
    if (!gradedMovies.containsKey(movie)) { 
        gradedMovies.put(movie, new ArrayList()); 
    }
    gradedMovies.get(movie).add(grade);
}