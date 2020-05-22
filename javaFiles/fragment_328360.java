LocalDateTime ldt = LocalDateTime.of(2015, 3, 29, 2, 30, 0, 0);
ZoneRules rules = ZoneId.of("Europe/Berlin").getRules();
ZoneOffsetTransition conflict = rules.getTransition(ldt);
if (conflict != null && conflict.isGap()) {
    ldt = conflict.getDateTimeAfter();
}
System.out.println(ldt); // 2015-03-29T03:00