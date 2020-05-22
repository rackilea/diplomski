int multiple = 2; //or whatever periodicity is needed
ReadablePeriod jodaPeriod;
switch (mPeriodType){
    case DAY:
        jodaPeriod = Days.days(multiple);
        break;
    case WEEK:
        jodaPeriod = Weeks.weeks(multiple);
        break;
    case MONTH:
        jodaPeriod = Months.months(multiple);
        break;
    case YEAR:
        jodaPeriod = Years.years(multiple);
        break;
    default:
        jodaPeriod = Months.months(multiple);
}
int count = 0;
LocalDateTime startTime = new LocalDateTime(mPeriodStart.getTime());
while (startTime.toDateTime().getMillis() < mPeriodEnd.getTime()){
    ++count;
    startTime = startTime.plus(jodaPeriod);
}
return count;