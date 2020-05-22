// define/create your intervals
    MomentInterval i1 =
        MomentInterval.between(Instant.ofEpochMilli(150), Instant.ofEpochMilli(200));
    MomentInterval i2 =
        MomentInterval.between(Instant.ofEpochMilli(230), Instant.ofEpochMilli(400));

// collect the intervals into an interval-collection
    IntervalCollection<Moment> ic =
        IntervalCollection.onMomentAxis().plus(Arrays.asList(i1, i2));

// define/create the outer time window
    MomentInterval window =
        MomentInterval.between(Instant.ofEpochMilli(100), Instant.ofEpochMilli(500));

// create/calculate the complement of the interval collection
    ic.withComplement(window)
      .getIntervals()
      .forEach(
        i ->
            System.out.println(
                "Range[" 
                + i.getStart().getTemporal().toTemporalAccessor().toEpochMilli() 
                + ", "
                + i.getEnd().getTemporal().toTemporalAccessor().toEpochMilli() 
                + "]"
            )
      );