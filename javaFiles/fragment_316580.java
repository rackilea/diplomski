DateTime dt = new DateTime(); // Now
    DateTime plusDuration = dt.plus(new Duration(110376000000L)); // Now plus three years and a half

    // Define and calculate the interval of time
    Interval interval = new Interval(dt.getMillis(), plusDuration.getMillis());

    // Parse the interval to period using the proper PeriodType
    Period period = interval.toPeriod(PeriodType.yearMonthDayTime());

    // Define the period formatter for pretty printing the period
    PeriodFormatter pf = new PeriodFormatterBuilder()
            .appendYears().appendSuffix("y ", "y ")
            .appendMonths().appendSuffix("m", "m ").appendDays()
            .appendSuffix("d ", "d ").appendHours()
            .appendSuffix("h ", "h ").appendMinutes()
            .appendSuffix("m ", "m ").appendSeconds()
            .appendSuffix("s ", "s ").toFormatter();

    // Print the period using the previously created period formatter
    System.out.println(pf.print(period).trim());