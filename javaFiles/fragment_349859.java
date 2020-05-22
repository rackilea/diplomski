Movie largestBudgetMovie = null;
for (Movie m : movie) {
    if (largestBudgetMovie == null ||
        m.getBudget() > largestBudgetMovie.getBudget())
          largestBudgetMovie = m; 
}
if (largestBudgetMovie == null)
    System.out.println("The list was empty");
else 
    System.out.println("The most expensive movie on my list was directed by " +
        largestBudgetMovie.getDirector());