public enum WeekDay {
    MONDAY("Monday", 1, ShiftPatternDTO::isMonday),
    TUESDAY("Tuesday", 2, ShiftPatternDTO::isTuesday),
    WEDNESDAY("Wednesday", 3, ShiftPatternDTO::isWednesday),
    THURSDAY("Thursday", 4, ShiftPatternDTO::isThursday),
    FRIDAY("Friday", 5, ShiftPatternDTO::isFriday),
    SATURDAY("Saturday", 6, ShiftPatternDTO::isSaturday),
    SUNDAY("Sunday", 7, ShiftPatternDTO::isSunday);

    public final String name;
    public final int num;
    public final Predicate<ShiftPatternDTO> pred;

    private WeekDay(String name, int num, Predicate<ShiftPatternDTO> pred) {
        this.name = name;
        this.num = num;
        this.pred = pred;
    }
}

private Set<WeekDay> getWeekPatternNew(ShiftPatternDTO shiftPattern) {
    return
        Arrays.stream(WeekDay.values())
        .filter(wd -> wd.pred.test(shiftPattern))
        .collect(Collectors.toSet());
}