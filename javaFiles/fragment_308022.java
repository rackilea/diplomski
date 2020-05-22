// create timezone object
DateTimeZone zone = DateTimeZone.forID("America/Sao_Paulo");

// check if a date is in DST
DateTime inDst = new DateTime(2017, 1, 1, 10, 0, zone);
// isStandardOffset returns false (it's in DST)
System.out.println(zone.isStandardOffset(inDst.getMillis()));
// check when it'll be the next DST change
DateTime nextDstChange = new DateTime(zone.nextTransition(inDst.getMillis()), zone);
System.out.println(nextDstChange); // 2017-02-18T23:00:00.000-03:00

// check if a date is in DST
DateTime noDst = new DateTime(2017, 6, 18, 10, 0, zone);
// isStandardOffset returns true (it's not in DST)
System.out.println(zone.isStandardOffset(noDst.getMillis()));
// check when it'll be the next DST change
nextDstChange = new DateTime(zone.nextTransition(noDst.getMillis()), zone);
System.out.println(nextDstChange); // 2017-10-15T01:00:00.000-02:00