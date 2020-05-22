DateTime dt = new DateTime();
DateTime twoHoursLater = dt.plusHours(2).plusMinutes(10).plusSeconds(5);
Period period = new Period(dt, twoHoursLater);
PeriodFormatter HHMMSSFormater = new PeriodFormatterBuilder()
        .printZeroAlways()
        .minimumPrintedDigits(2)
        .appendHours().appendSeparator("-")
        .appendMinutes().appendSeparator("-")
        .appendSeconds()
        .toFormatter(); // produce thread-safe formatter
System.out.println(HHMMSSFormater.print(period));