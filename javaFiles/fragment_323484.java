Duration dur = Duration.between(start.toLocalTime(), end.toLocalTime());
LocalDate e = end.toLocalDate();
if (dur.isNegative()) {
    dur = dur.plusDays(1);
    e = e.minusDays(1);
}
Period per = Period.between(start.toLocalDate(), e);
System.out.println(per.toString() + ", " + dur.toString());