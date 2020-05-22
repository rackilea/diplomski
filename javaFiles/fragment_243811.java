static class DataPointSummary {
    final DoubleSummaryStatistics x=new DoubleSummaryStatistics();
    final DoubleSummaryStatistics y=new DoubleSummaryStatistics();

    public double getAverageX() {
        return x.getAverage();
    }
    public double getAverageY() {
        return y.getAverage();
    }
    public void add(DataPoint p) {
        x.accept(p.getX());
        y.accept(p.getY());
    }
    public DataPointSummary merge(DataPointSummary s) {
        x.combine(s.x);
        y.combine(s.y);
        return this;
    }
    @Override
    public String toString() {
        return "DataPointSummary["+x.getCount()+" points"
            +", avg x="+getAverageX()+", avg y="+getAverageY()+']';
    }
}