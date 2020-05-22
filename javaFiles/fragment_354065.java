public boolean compare(List<Task> source, List<Task> actual) {
    Set<Task> intersection = new HashSet<>(source);
    Set<Task> sourceDifference = new HashSet<>(source);
    Set<Task> actualDifference = new HashSet<>(actual);

    intersection.retainAll(actualDifference);

    sourceDifference.removeAll(intersection);
    for (Task t: sourceDifference) {
        System.out.println(String.format("Task %s not present in actual", t));
    }

    actualDifference.removeAll(intersection);
    for (Task t: actualDifference) {
        System.out.println(String.format("Task %s not present in source", t));
    }

    return sourceDifference.isEmpty() && actualDifference.isEmpty();
}