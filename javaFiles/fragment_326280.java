System.out.println(
    org.apache.commons.lang.time.DurationFormatUtils.formatPeriod(
            startDate.getTime(), 
            endDate.getTime(), 
            "y' years 'M' months 'd' days 'H' hours 'm' minutes 's' seconds'"
    )
    .replaceAll("(?<!\\d)0 (\\w+) ?", "")
    .replaceAll("(?<!\\d)1 (\\w+)s", "1 $1")
);