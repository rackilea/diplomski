// create timezone object
ZoneId zone = ZoneId.of("America/Sao_Paulo");
// get the timezone's rules
ZoneRules rules = zone.getRules();

// check if a date is in DST
ZonedDateTime inDST = ZonedDateTime.of(2017, 1, 1, 10, 0, 0, 0, zone);
// isDaylightSavings returns true (it's in DST)
System.out.println(rules.isDaylightSavings(inDST.toInstant()));
// check when it'll be the next DST change
ZoneOffsetTransition nextTransition = rules.nextTransition(inDST.toInstant());
// getInstant() returns the UTC instant; atZone converts to the specified timezone
System.out.println(nextTransition.getInstant().atZone(zone)); // 2017-02-18T23:00-03:00[America/Sao_Paulo]

// you can also check the date/time and offset before and after the DST change
// in this case, at 19/02/2017, the clock is moved 1 hour back (from midnight to 11 PM)
ZonedDateTime beforeDST = ZonedDateTime.of(nextTransition.getDateTimeBefore(), nextTransition.getOffsetBefore());
System.out.println(beforeDST); // 2017-02-19T00:00-02:00
ZonedDateTime afterDST = ZonedDateTime.of(nextTransition.getDateTimeAfter(), nextTransition.getOffsetAfter());
System.out.println(afterDST); // 2017-02-18T23:00-03:00

// check if a date is in DST
ZonedDateTime noDST = ZonedDateTime.of(2017, 6, 1, 10, 0, 0, 0, zone);
// isDaylightSavings returns false (it's not in DST)
System.out.println(rules.isDaylightSavings(noDST.toInstant()));
// check when it'll be the next DST change
nextTransition = rules.nextTransition(noDST.toInstant());
// getInstant() returns the UTC instant; atZone converts to the specified timezone
System.out.println(nextTransition.getInstant().atZone(zone)); // 2017-10-15T01:00-02:00[America/Sao_Paulo]

// you can also check the date/time and offset before and after the DST change
// in this case, at 15/10/2017, the clock is moved 1 hour forward (from midnight to 1 AM)
beforeDST = ZonedDateTime.of(nextTransition.getDateTimeBefore(), nextTransition.getOffsetBefore());
System.out.println(beforeDST); // 2017-10-15T00:00-03:00
afterDST = ZonedDateTime.of(nextTransition.getDateTimeAfter(), nextTransition.getOffsetAfter());
System.out.println(afterDST); // 2017-10-15T01:00-02:00