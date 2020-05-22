ExecutorService executor = Executor.newFixedThreadPool(2);
FutureTask<List<ConditionFact>> task1 = getConditionFacts(member);
FutureTask<List<ConditionFact>> task2 = getRiskFacts(member);
executor.execute(task1);
executor.execute(task2);
// wait for the task to complete and get the result:
try {
    List<ConditionFact> conditionFacts = task1.get();
}
catch (ExecutionException e) {
    // an exception occurred.
    Throwable cause = e.getCause(); // cause is the original exception thrown by the DAO
}
// wait for the task to complete and get the result:
try {
    List<RiskFact> conditionFacts = task2.get();
}
catch (ExecutionException e) {
    // an exception occurred.
    Throwable cause = e.getCause(); // cause is the original exception thrown by the DAO
}