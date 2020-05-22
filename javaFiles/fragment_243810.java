static class DataPointSummary {
    long count;
    double sumX, sumY;

    public double getAverageX() {
        return count==0? 0: sumX/count;
    }
    public double getAverageY() {
        return count==0? 0: sumY/count;
    }
    public void add(DataPoint p) {
        count++;
        sumX+=p.getX();
        sumY+=p.getY();
    }
    public DataPointSummary merge(DataPointSummary s) {
        count+=s.count;
        sumX+=s.sumX;
        sumY+=s.sumY;
        return this;
    }
    @Override
    public String toString() {
        return "DataPointSummary["+count+" points"
            +", avg x="+getAverageX()+", avg y="+getAverageY()+']';
    }
}