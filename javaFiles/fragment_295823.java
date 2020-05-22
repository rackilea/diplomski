ZoneId zone = ZoneId.of("CET");
System.out.println(zone);
System.out.println(zone.getRules());
for (ZoneOffsetTransition trans : zone.getRules().getTransitions()) {
  System.out.println(trans);
}
for (ZoneOffsetTransitionRule rule : zone.getRules().getTransitionRules()) {
  System.out.println(rule);
}