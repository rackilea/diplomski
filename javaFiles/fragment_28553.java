public int getDayInFirstWeek(int curYear , int curMonth , int day)
{
    Calendar forDay = new GregorianCalendar(curYear, curMonth, day);
    dayFirstWeek = forDay.get(GregorianCalendar.DAY_OF_WEEK);
    return dayFirstWeek;
}