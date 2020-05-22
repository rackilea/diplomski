DateInterval a = DateInterval.between(PlainDate.of(2009, 1, 1), PlainDate.of(2014, 1, 1));
DateInterval b = DateInterval.between(PlainDate.of(2009, 1, 1), PlainDate.of(2009, 1, 2));
DateInterval c = DateInterval.between(PlainDate.of(2009, 1, 2), PlainDate.of(2009, 1, 3));
DateInterval d = DateInterval.between(PlainDate.of(2009, 1, 4), PlainDate.of(2009, 1, 4));
DateInterval e = DateInterval.between(PlainDate.of(2010, 1, 1), PlainDate.of(2011, 1, 1));
DateInterval f = DateInterval.between(PlainDate.of(2011, 1, 1), PlainDate.of(2012, 1, 1));
DateInterval g = DateInterval.between(PlainDate.of(2015, 1, 1), PlainDate.of(2016, 1, 1));

List<DateInterval> intervals = Arrays.asList(a, b, c, d, e, f, g);

IntervalCollection<PlainDate> icoll = IntervalCollection.onDateAxis().plus(intervals);

for (ChronoInterval<PlainDate> gap : icoll.withGaps().getIntervals()) {
    icoll = icoll.plus(gap);
}

System.out.println(icoll.withSplits());

[2009-01-01/2009-01-01],
[2009-01-02/2009-01-02],
[2009-01-03/2009-01-03],
[2009-01-04/2009-01-04],
[2009-01-05/2009-12-31],
[2010-01-01/2010-12-31],
[2011-01-01/2011-01-01],
[2011-01-02/2012-01-01],
[2012-01-02/2014-01-01],
[2014-01-02/2014-12-31],
[2015-01-01/2016-01-01]