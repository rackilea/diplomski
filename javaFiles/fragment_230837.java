PeriodFormatter hoursAndMinutesFormatter = new PeriodFormatterBuilder()
.printZeroAlways()
.minimumPrintedDigits(2)
.appendHours()
.appendSeparator(":")
//.rejectSignedValues(true) // no effect ?!
.appendMinutes()
.toFormatter();     

long millis = -27900000;
Duration d =  new Duration(millis);
Period p = d.toPeriod();
String s;
if (millis < 0) {
    s = "-" + hoursAndMinutesFormatter.print(p.negated());
} else {
    s = hoursAndMinutesFormatter.print(p);
}

System.out.println("Joda-Time: " + s); // -07:45