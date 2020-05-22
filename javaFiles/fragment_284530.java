String mydate = "20130812214600025";
DateTime date =
    DateTime.parse(
        mydate,
        DateTimeFormat.forPattern("yyyyMMddHHmmssSSS"));
System.out.println(date); // 2013-08-12T21:46:00.025+02:00
System.out.println(date.toInstant().getMillis()); // 1376336760025