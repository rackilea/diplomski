final class TaskResult {
    private final Supplier<Boolean> needToBeScheduled;
    private final Supplier<Boolean> needToBeResubmitted;

    private TaskResult(Supplier<Boolean> needToBeScheduled, Supplier<Boolean> needToBeResubmitted) {
        this.needToBeScheduled = needToBeScheduled;
        this.needToBeResubmitted = needToBeResubmitted;
    }

    public static TaskResult of(Supplier<Boolean> needToBeScheduled, Supplier<Boolean> needToBeResubmitted) {
        return new TaskResult(needToBeScheduled, needToBeResubmitted);
    }

    public boolean needToBeScheduled() {
        return needToBeScheduled != null && needToBeScheduled.get();
    }

    public boolean needToBeResubmitted() {
        return needToBeResubmitted != null && needToBeResubmitted.get();
    }
}