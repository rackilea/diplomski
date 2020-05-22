import org.joda.time.DateTime;
    import org.joda.time.Period;

    ...

    DateTime now = new DateTime();
    DateTime oneWeekFromNow = now.plus(Period.weeks(1));
    System.out.println("oneWeekFromNow = " + oneWeekFromNow);