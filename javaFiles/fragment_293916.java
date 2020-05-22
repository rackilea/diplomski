DateTime myBirthDate = new DateTime(1978, 3, 26, 12, 35, 0, 0);
DateTime now = new DateTime();
Period period = new Period(myBirthDate, now);

PeriodFormatter formatter = new PeriodFormatterBuilder()
    .appendSeconds().appendSuffix(" seconds ago\n")
    .appendMinutes().appendSuffix(" minutes ago\n")
    .appendHours().appendSuffix(" hours ago\n")
    .appendDays().appendSuffix(" days ago\n")
    .appendWeeks().appendSuffix(" weeks ago\n")
    .appendMonths().appendSuffix(" months ago\n")
    .appendYears().appendSuffix(" years ago\n")
    .printZeroNever()
    .toFormatter();

String elapsed = formatter.print(period);
System.out.println(elapsed);