public enum Day {
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true),
    SATURDAY(false),
    SUNDAY(false);

    private final boolean workDay;

    private Day(boolean workDay) {
        this.workDay = workDay;
    }

    public boolean isWorkDay() {
        return workDay;
    }
}