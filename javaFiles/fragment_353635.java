public static long getRemainingCompanyBalanceLambda ( long initialBalance, List<ArrayList<PersonalExpense>> total) {

   int sum = total.stream()
        .flatMap(List::stream)
        .mapToInt(PersonalExpense::getCurrentExpenses)
        .sum();

   return initialBalance - sum;

}