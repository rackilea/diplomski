PeriodFormatterBuilder builder = new PeriodFormatterBuilder();

  PeriodFormatter formatter =
    builder.printZeroAlways()
      .minimumPrintedDigits(2)
      .appendHours()
      .appendSeparator(":")
      .appendMinutes()
      .appendSeparator(":")
      .appendSeconds()
      .toFormatter();

  String zero = "00:00:00";
  Period period = formatter.parsePeriod(zero);
  float total = 0;

  for (Activity temp : last7acts) {
    System.out.println(
      temp.getCatName() + " - " + temp.getTime()
      + " - " + temp.getDistance() + " " + temp.getUnits());
    total += temp.getDistance();
    period = period.plus(formatter.parsePeriod(temp.getTime()));
  }

  period = period.normalizedStandard(PeriodType.dayTime().withDaysRemoved());
  System.out.println("Final Distance: " + total);
  System.out.println("Final Time: " + formatter.print(period));

  long secs = period.toStandardDuration().getStandardSeconds();
  NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
  System.out.println(nf.format(secs / total) + " seconds/mile");

  long minutes = secs / 60;
  System.out.println(nf.format(minutes / total) + " minutes/mile");