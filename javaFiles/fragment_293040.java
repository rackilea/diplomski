PersianCalendar start = PersianCalendar.of(1392, PersianMonth.ESFAND, 27);
 PersianCalendar end = PersianCalendar.of(1393, PersianMonth.FARVARDIN, 6);

 SimpleInterval<PersianCalendar> i1 =
   SimpleInterval.on(PersianCalendar.axis()).between(start, end);
 SimpleInterval<PersianCalendar> i2 =
   SimpleInterval.on(PersianCalendar.axis()).between(
     end.minus(CalendarDays.ONE),
     end.plus(CalendarDays.ONE));

 System.out.println(
   interval.findIntersection(
     SimpleInterval.on(PersianCalendar.axis()).between(
       end.minus(CalendarDays.ONE), end.plus(CalendarDays.ONE))).get());
 // [AP-1393-01-05/AP-1393-01-06]