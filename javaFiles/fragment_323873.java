static final List<Interval> intervals = new ArrayList<Interval>();
   static
   {
      intervals.add(new Interval(new DateTime(1990, 05, 15, 00, 00, 00, 00), new DateTime(1990, 05, 18, 00, 00, 00, 00)));
      intervals.add(new Interval(new DateTime(1990, 04, 28, 00, 00, 00, 00), new DateTime(1990, 05, 18, 00, 00, 00, 00)));
      intervals.add(new Interval(new DateTime(1990, 05, 17, 00, 00, 00, 00), new DateTime(1990, 05, 21, 00, 00, 00, 00)));
      intervals.add(new Interval(new DateTime(1990, 05, 21, 00, 00, 00, 00), new DateTime(1990, 05, 29, 00, 00, 00, 00)));
      intervals.add(new Interval(new DateTime(1990, 05, 22, 00, 00, 00, 00), new DateTime(1990, 05, 25, 00, 00, 00, 00)));
      intervals.add(new Interval(new DateTime(1990, 05, 27, 00, 00, 00, 00), new DateTime(1990, 06, 02, 00, 00, 00, 00)));
   }

   public static void main(String[] args)
   {
      final DateTime startOfMonth = new DateTime(1990, 05, 01, 00, 00);
      final Interval monthInterval = new Interval(startOfMonth, startOfMonth.plusMonths(1));

      covers(monthInterval, intervals);
   }

   static boolean covers(Interval month, List<Interval> intervals)
   {
      final MutableInterval monthInterval = new MutableInterval(month);
      start: for (final Interval interval : intervals)
      {
         if (interval.getStartMillis() <= monthInterval.getStartMillis()
            && interval.getEndMillis() > monthInterval.getStartMillis())
         {
            if (interval.getEndMillis() > monthInterval.getStartMillis())
            {
               return true;
            }
            monthInterval.setStartMillis(interval.getEndMillis());
            continue start;
         }
      }
      return monthInterval.getStartMillis()== monthInterval.getEndMillis();
   }