if (movie.size() > 0) {
    Movie largestBudgetMovie = movie.get(0);
    for (int i = 1; i < movie.size(); ++i) {
        Movie m = movie.get(i);
        if (m.getBudget() > largestBudgetMovie.getBudget())
              largestBudgetMovie = m; 
    }       
    System.out.println("The most expensive movie on my list was directed by " +
        largestBudgetMovie.getDirector());
}
else 
    System.out.println("The list was empty");