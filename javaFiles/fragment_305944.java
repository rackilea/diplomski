class IntervalStartComparator implements java.util.Comparator<Interval> {

    @Override
    public int compare( Interval x, Interval y ) {
        return x.getStart().compareTo( y.getStart() );
    }
}