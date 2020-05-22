PeriodFormatter formatter = new PeriodFormatterBuilder()
        .printZeroAlways().minimumPrintedDigits(2)
        .appendHours().appendSuffix(":").appendMinutes().appendSuffix(":").appendSeconds()
        .toFormatter();
Period period1 = formatter.parsePeriod("12:04:45");
Period period2 = formatter.parsePeriod("13:04:45");
Period difference1 = period1.minus(period2).normalizedStandard();
System.out.println(formatter.print(difference1));

Period period3 = formatter.parsePeriod("15:13:32");
Period period4 = formatter.parsePeriod("12:04:45");
Period difference2 = period3.minus(period4).normalizedStandard();
System.out.println(formatter.print(difference2));