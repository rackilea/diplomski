class SeasonCalculator {
    private static final int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int month;
    private final int day;

    public SeasonCalculator(int month, int day) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Not a valid month: " + month);
        }
        if (day < 1 || day > days[month - 1]) {
            throw new IllegalArgumentException("Not a valid day: " + day + " for month " + month);
        }
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}