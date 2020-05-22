import static net.time4j.tz.GapResolver.NEXT_VALID_TIME;
import static net.time4j.tz.OverlapResolver.EARLIER_OFFSET;

PlainTimestamp tsp = PlainTimestamp.of(2015, 3, 29, 2, 30);
Moment nextValidTime = // equivalent of java.time.Instant
  tsp.in(Timezone.of(EUROPE.BERLIN).with(NEXT_VALID_TIME.and(EARLIER_OFFSET)));
tsp = nextValidTime.toZonalTimestamp(EUROPE.BERLIN);
System.out.println(tsp);
// 2015-03-29T03 (minute is zero and therefore left out here)