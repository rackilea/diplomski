import static net.time4j.PlainDate.DAY_OF_WEEK;
import static net.time4j.Weekday.FRIDAY;

File myFile = new File("");
long timeSinceCreateFile = myFile.lastModified();

// conversion to global timestamp in Time4J-format
Moment fileTSP = TemporalTypes.MILLIS_SINCE_UNIX.transform(timeSinceCreateFile);

// what ever you need (or just TZID timezone = Timezone.ofSystem().getID();)
TZID timezone = AMERICA.MONTREAL;

// "next friday" is a local time condition => convert to local timestamp
PlainTimestamp localTSP = fileTSP.toZonalTimestamp(timezone);
PlainTime walltime2130 = PlainTime.of(21, 30);

// move to next time 21:30 (possibly on next day) and then to next or same Friday
localTSP =
    localTSP.with(PlainTime.COMPONENT.setToNext(walltime2130))
            .with(DAY_OF_WEEK.setToNextOrSame(FRIDAY));

// convert current time to local timestamp and compare at 21:30
boolean downloadNeeded = SystemClock.inZonalView(timezone).now().isAfter(localTSP);