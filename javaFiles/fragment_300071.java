public final class CalendarMonth implements Comparable<CalendarMonth> {
    private final YearMonth yearMonth;
    private final Locale    locale;
    private final DayOfWeek firstWeekdayOfWeek;
    private final int[][]   weekdays;

    public static CalendarMonth of(int year, int month) {
        return new CalendarMonth(YearMonth.of(year, month), Locale.getDefault());
    }
    public static CalendarMonth of(int year, int month, Locale locale) {
        Objects.requireNonNull(locale, "locale");
        return new CalendarMonth(YearMonth.of(year, month), locale);
    }
    public static CalendarMonth of(int year, Month month) {
        return new CalendarMonth(YearMonth.of(year, month), Locale.getDefault());
    }
    public static CalendarMonth of(int year, Month month, Locale locale) {
        Objects.requireNonNull(locale, "locale");
        return new CalendarMonth(YearMonth.of(year, month), locale);
    }
    public static CalendarMonth of(YearMonth yearMonth) {
        Objects.requireNonNull(yearMonth, "yearMonth");
        return new CalendarMonth(yearMonth, Locale.getDefault());
    }
    public static CalendarMonth of(YearMonth yearMonth, Locale locale) {
        Objects.requireNonNull(yearMonth, "yearMonth");
        Objects.requireNonNull(locale, "locale");
        return new CalendarMonth(yearMonth, locale);
    }

    private CalendarMonth(YearMonth yearMonth, Locale locale) {
        this.yearMonth = yearMonth;
        this.locale = locale;

        // Build weekdays array
        this.firstWeekdayOfWeek = WeekFields.of(this.locale).getFirstDayOfWeek();
        DayOfWeek firstWeekdayOfMonth = this.yearMonth.atDay(1).getDayOfWeek();
        int startWeekDay = (firstWeekdayOfMonth.getValue() - this.firstWeekdayOfWeek.getValue() + 7) % 7;
        int endWeekDay = startWeekDay + this.yearMonth.lengthOfMonth();
        this.weekdays = new int[(endWeekDay + 6) / 7][7];
        for (int weekDay = startWeekDay, dayOfMonth = 1; weekDay < endWeekDay; weekDay++, dayOfMonth++)
            this.weekdays[weekDay / 7][weekDay % 7] = dayOfMonth;
    }

    public void print() {
        // Get day names and determine width of longest name
        String[] dayName = new String[7];
        for (int i = 0; i < 7; i++)
            dayName[i] = this.firstWeekdayOfWeek.plus(i).getDisplayName(TextStyle.FULL, this.locale);
        int width = Arrays.stream(dayName).mapToInt(String::length).max().getAsInt();

        // Print month name
        String title = this.yearMonth.format(DateTimeFormatter.ofPattern("MMMM uuuu", this.locale));
        System.out.println(rightTrim(center(title, width * 7 + 6)));

        // Print day names
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 7; i++)
            line.append(center(dayName[i], width)).append(' ');
        System.out.println(rightTrim(line.toString()));

        // Print day numbers
        for (int[] week : this.weekdays) {
            line.setLength(0);
            for (int i = 0; i < 7; i++)
                line.append(center((week[i] == 0 ? "" : String.format("%2d", week[i])), width)).append(' ');
            System.out.println(rightTrim(line.toString()));
        }
    }
    private static String center(String text, int width) {
        if (text.length() >= width)
            return text;
        char[] buf = new char[width];
        Arrays.fill(buf, ' ');
        System.arraycopy(text.toCharArray(), 0, buf, (width - text.length() + 1) / 2, text.length());
        return new String(buf);
    }
    private static String rightTrim(String text) {
        return text.replaceFirst("\\s+$", "");
    }

    @Override
    public String toString() {
        return this.yearMonth.toString();
    }
    @Override
    public int compareTo(CalendarMonth that) {
        int cmp = this.yearMonth.compareTo(that.yearMonth);
        if (cmp == 0)
            cmp = this.locale.toLanguageTag().compareTo(that.locale.toLanguageTag());
        return cmp;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof CalendarMonth) {
            CalendarMonth other = (CalendarMonth) obj;
            return (this.yearMonth.equals(other.yearMonth) &&
                    this.locale.equals(other.locale));
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.yearMonth, this.locale);
    }
}