Instant i;
ZoneOffsetTransition transition = someZoneId.getRules().getTransition(ldt)
if (transition == null) {
    i = ldt.toInstant(someZoneId.getRules().getOffset(ldt));
} else {
    i = ldt.toInstant(transition.getOffsetAfter());
}