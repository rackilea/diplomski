DateTime start = new DateTime(Start.geDate().getTime());
DateTime end = new DateTime(End.geDate().getTime());

// You might need to use end, start instead, depending on which
// is later
Duration duration = new Duration(start, end);
Period period = duration.toPeriod();