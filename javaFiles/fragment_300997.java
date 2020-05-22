class Job implements Comparable<Job> {
    @Override
    public int compareTo(final Job other) {
        return getPriorityLevel() - other.getPriorityLevel();
    }
}