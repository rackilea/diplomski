public int compare(TimedTask task1, TimedTask task2) {
    int executionTimeBasedComparisonResult = task1.getExecutionTime().compareTo(task2.getExecutionTime());
    if (executionTimeBasedComparisonResult == 0) { // two execution times are equal
        return task1.getUuid().compareTo(task2.getUuid());
    }
    return executionTimeBasedComparisonResult;
}