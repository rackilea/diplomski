this.firstWeekdayOfWeek = WeekFields.of(this.locale).getFirstDayOfWeek();
DayOfWeek firstWeekdayOfMonth = this.yearMonth.atDay(1).getDayOfWeek();
int startWeekDay = (firstWeekdayOfMonth.getValue() - this.firstWeekdayOfWeek.getValue() + 7) % 7;
int endWeekDay = startWeekDay + this.yearMonth.lengthOfMonth();
this.weekdays = new int[(endWeekDay + 6) / 7][7];
for (int weekDay = startWeekDay, dayOfMonth = 1; weekDay < endWeekDay; weekDay++, dayOfMonth++)
    this.weekdays[weekDay / 7][weekDay % 7] = dayOfMonth;