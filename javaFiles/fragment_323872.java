static boolean covers(Interval month, List<Interval> intervals)
{
  //assumes intervals are sorted already on start times
  final MutableInterval monthInterval = new MutableInterval(month);
  start: for (final Interval interval : intervals)
  {
     if (interval.getStartMillis() <= monthInterval.getStartMillis()
        && interval.getEndMillis() > monthInterval.getStartMillis())
     {
        if (interval.getEndMillis() > monthInterval.getEndMillis())
        {
           return true;
        }
        monthInterval.setStartMillis(interval.getEndMillis());
        // continue start;  // loop continues regardless
     } else {
           if (interval.overlaps(month)) return false;
     }
  }
  return monthInterval.getStartMillis()== monthInterval.getEndMillis();
}