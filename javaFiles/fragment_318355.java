private Set<Interval<T>> intervalSet;

private IntervalUnion() {
this.intervalSet = 
    new TreeSet<Interval<T>>(
      IntervalComparator.<T>getInstance());
// ... add Interval<T> objects into intervalSet ...
}