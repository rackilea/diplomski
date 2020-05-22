static class Task {
    LocalDate start;
    LocalDate end;
    Set<String> actionItems;

    public Task(LocalDate start, LocalDate end,
            Collection<String> actionItems) {
        this.start = start;
        this.end = end;
        this.actionItems = new HashSet<>(actionItems);
    }

    @Override
    public String toString() {
        return start + ".." + end + ": "+actionItems;
    }
}